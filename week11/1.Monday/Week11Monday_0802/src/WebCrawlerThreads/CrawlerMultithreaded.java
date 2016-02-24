package WebCrawlerThreads;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.impl.client.DefaultHttpClient;

public class CrawlerMultithreaded {

	private static ThreadPoolExecutor es;
	private static Set<Future<URI>> setOfFutures;
	private static final Set<URI> visitedUrls = Collections.synchronizedSet(new HashSet<URI>());
	private static URI uri_found;

	// private static List<Future<URI>> resultList=new ArrayList<>();

	static class Task implements Callable<URI> {
		private URI currentLocation;
		private final String needle;
		private String name;

		public Task(URI currentLocation, final String needle, String name) {
			this.currentLocation = currentLocation;
			this.needle = needle;
			this.name = name;
		}

		public URI call() {

			URI returnURI = null;
			try {
				// System.out.println("call task:" + currentLocation);
				returnURI = crawl(currentLocation, needle, name);
			} catch (URISyntaxException | MalformedURLException | InterruptedException | ExecutionException e) {
				;// e.printStackTrace();
			}
			return returnURI;
		}
	}

	public static URI crawl(URI currentLocation, final String needle, String name)
			throws URISyntaxException, MalformedURLException, InterruptedException, ExecutionException {
		String urlContents = "";
		if (!es.isShutdown()) {
			urlContents = downloadContents(currentLocation);
		}
		synchronized (visitedUrls) {
			visitedUrls.add(currentLocation);
			visitedUrls.notify();
		}

		if (urlContents.contains(needle) && !es.isShutdown()) {
			System.out.println("found it-" + name);
			// synchronized(uri_found){
			uri_found = currentLocation;
			// uri_found.notifyAll();
			// }
			es.shutdownNow();
			return currentLocation;
		} else {
			for (String link : getAllLinks(urlContents)) {
				// if (Thread.currentThread().isInterrupted())
				if (es.isShutdown())
					break;
				final URI asUri = normalizeLink(currentLocation, link);
				boolean isVisited = false;
				synchronized (visitedUrls) {
					isVisited = visitedUrls.contains(asUri);
					if (!isVisited)
						visitedUrls.add(asUri);
					visitedUrls.notify();
				}
				if (!isVisited && isInsideDomain(currentLocation, asUri)) {

					synchronized (setOfFutures) {
						Task task = new Task(asUri, needle, ((Integer) setOfFutures.size()).toString());

						if (!es.isTerminated()) {
							{
								setOfFutures.add(es.submit(task));
								setOfFutures.notify();
							}
						}
						// URI uri=localURI.get();
						// URI result = crawl(asUri, needle);
						// if (uri != null) {

						// return uri;
						// }
					}
				}
			}

			return null;
		}
	}

	private static boolean isInsideDomain(URI currentLocation, URI asUrl) throws URISyntaxException {
		return currentLocation.getHost().equals(asUrl.getHost());
	}

	private static URI normalizeLink(URI currentLocation, String link)
			throws MalformedURLException, URISyntaxException {
		URI uri = new URI(link);
		if (uri.getScheme() != null && uri.getHost() != null) {
			return uri;
		}
		return URIUtils.resolve(currentLocation, uri);
	}

	private static String downloadContents(URI startLocation) throws URISyntaxException {
		HttpClient httpClient = new DefaultHttpClient();
		System.out.println("Currently crawling : " + startLocation);
		HttpGet get = new HttpGet(startLocation);
		try {
			HttpResponse response = httpClient.execute(get);
			String contents = IOUtil.toString(response.getEntity().getContent());
			return contents;
		} catch (IOException e) {
			e.printStackTrace();
			// IO Error when connecting to the server, whatever, just return
			// empty contents
			return "";
		}
	}

	private static List<String> getAllLinks(String content) {
		ArrayList<String> resultList = new ArrayList<>();
		String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			resultList.add(matcher.group(1));
		}
		return resultList;
	}

	public static void main(String[] args)
			throws IOException, URISyntaxException, InterruptedException, ExecutionException {

		long startTime = System.currentTimeMillis();
		es = (ThreadPoolExecutor) Executors.newFixedThreadPool(40);
		uri_found = new URI("http://not_found");
		setOfFutures = Collections.synchronizedSet(new HashSet<Future<URI>>());

		// WebCrawler crawler = new WebCrawler();
		URI startLocation = new URI("http://9gag.com/");

		Task task = new Task(startLocation, "school", "first");
		setOfFutures.add(es.submit(task));
		if (es.awaitTermination(100, TimeUnit.SECONDS)) {
			System.out.println("threads STOPPED: " + es.getActiveCount() + " all tasks: " + es.getTaskCount());
		} else {
			es.shutdownNow();
		}
		System.out.println(uri_found);
		System.out.println(System.currentTimeMillis() - startTime + " millisecond");
		synchronized (visitedUrls) {
			System.out.println("visitedUrls size:" + visitedUrls.size());
		}
		
		
		synchronized (setOfFutures) {
			System.out.println("threads waiting: " + es.getActiveCount() + " all tasks: " + es.getTaskCount());
			/*
			 * for (Future<URI> future : setOfFutures) { System.out.println(
			 * "sled for each"+setOfFutures.size()); try{ if (future.get(10,
			 * TimeUnit.MILLISECONDS) != null) { System.out.println("result :" +
			 * future.get().toString()); break; } } catch (TimeoutException
			 * timeout){ //timeout.printStackTrace(); } }
			 */
		}

		// URI result = crawler.crawl(startLocation, "junk");
		// System.out.println("result :" + result.toString());
	}
}
