package WebCrawler;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class SpiderLeg {

	// We'll use a fake USER_AGENT so the web server thinks the robot is a
	// normal web browser

	private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";

	private List<String> links = new LinkedList<String>(); // a list of urls
	private Document htmlDocument; // our webpage i.e. our document

	public boolean crawl(String url) { // Give it a URL and it makes an HTTP
		try {
			Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
			Document htmlDocument = connection.get();
			this.htmlDocument = htmlDocument;
			if (connection.response().statusCode() == 200) // 200 is the HTTP OK
															// status code
			{
				System.out.println("\n**Visiting** Received web page at " + url);
			}

			if (!connection.response().contentType().contains("text/html")) {
				System.out.println("**Failure** Retrieved something other that HTML");
				return false;
			}
			Elements linksOnPage = htmlDocument.select("a[href]");
			System.out.println("Found (" + linksOnPage.size() + "),links");
			for (Element link : linksOnPage) {
				this.links.add(link.absUrl("href"));
			}

			return true;

		} catch (IOException ioe) {
			// We were not successful in out http request
			// System.out.println("Error in our HTTP request "+ioe);
			return false;
		}
	}

	public boolean searchForWord(String searchWord) { // Tries to find a word on
														// the page
		if (this.htmlDocument == null) {
			System.out.println("ERROR! Call crawl() before performing analysis on the document");
			return false;
		}
		System.out.println("Searching for the word " + searchWord + "...");
		String bodyText = this.htmlDocument.body().text();
		return bodyText.toLowerCase().contains(searchWord.toLowerCase());
	}

	public List<String> getLinks() { // Returns a list of all the URLS on the
										// page
		return this.links;
	}
}
