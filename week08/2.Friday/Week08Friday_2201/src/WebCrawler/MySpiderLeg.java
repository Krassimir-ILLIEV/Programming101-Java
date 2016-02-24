package WebCrawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MySpiderLeg {

	// We'll use a fake USER_AGENT so the web server thinks the robot is a
	// normal web browser

	private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";

	private String contentDocument; // our webpage i.e. our document

	private static List<String> getAllLinks(String url,String content) {
        ArrayList<String> resultList = new ArrayList<>();
        String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
        	String uRl=matcher.group(1);
//    		System.out.println("url -------------------" + url );
//    		System.out.println("URl -------------------" + uRl );
        	if (uRl.indexOf("http")!=0)
        		uRl=url+"/"+uRl;
        	uRl = uRl.replaceAll("//", "/").trim();
        	uRl = uRl.replaceAll(":/", "://").trim();
        	
    		System.out.println("Url -------------------" + uRl );
        	resultList.add(uRl);
        	
        }
        return resultList;
    }
	
	public List<String> crawl(String url) { // Give it a URL and it makes an HTTP
		contentDocument=null;
		//System.out.println("Url -------------------" + url );
		List<String> links = new LinkedList<String>(); // a list of urls
		try {
			Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
			Document htmlDocument = connection.get();
			if (connection.response().statusCode() == 200) // 200 is the HTTP OK
															// status code
			{
				System.out.println("\n**Visiting** Received web page at " + url);
			}

			if (!connection.response().contentType().contains("text/html")) {
				System.out.println("**Failure** Retrieved something other that HTML");
				return null;
			}
			
			this.contentDocument=htmlDocument.toString();
		//	links=getAllLinks(url,this.contentDocument);
		//*	
			Elements linksOnPage = htmlDocument.select("a[href]");
			for (Element link : linksOnPage) {
				links.add(link.absUrl("href"));
			}
		// */	
			System.out.println("Found (" + links.size() + "),links");

			return links;

		} catch (IOException ioe) {
			// We were not successful in out http request
			// System.out.println("Error in our HTTP request "+ioe);
			return null;
		}
	}

	public boolean searchForWord(String searchWord) { // Tries to find a word on
														// the page
		if (this.contentDocument == null) {
			System.out.println("ERROR! Call crawl() before performing analysis on the document");
			return false;
		}
		System.out.println("Searching for the word " + searchWord + "...");
		return this.contentDocument.toLowerCase().contains(searchWord.toLowerCase());
	}

}
