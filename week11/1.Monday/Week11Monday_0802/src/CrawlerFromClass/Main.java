package CrawlerFromClass;


	import java.io.IOException;
	import java.net.URI;
	import java.net.URISyntaxException;
	import java.util.concurrent.ExecutionException;

	public class Main {
		public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException,
				ExecutionException {
			long startTime=System.currentTimeMillis();
			WebCrawler crawler = new WebCrawler();

			URI startLocation = new URI("http://9gag.com/");
			URI result = crawler.crawl(startLocation, "school");
			System.out.println("result :" + result.toString());
			System.out.println(System.currentTimeMillis()-startTime);
		}

	}

