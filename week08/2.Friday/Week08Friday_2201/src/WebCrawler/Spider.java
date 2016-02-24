package WebCrawler;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Spider {

	// Fields
	private static final int MAX_PAGES_TO_SEARCH = 50;
	private Set<String> pagesVisited = new HashSet<String>();
	private Queue<String> pagesToVisit = new ArrayDeque<String>();

	public void search(String url, String searchWord) {
		while (this.pagesVisited.size() < MAX_PAGES_TO_SEARCH) {
			String currentUrl;
			SpiderLeg leg = new SpiderLeg();
			if (this.pagesToVisit.isEmpty()) {
				currentUrl = url;
				this.pagesVisited.add(url);
			} else {
				currentUrl = this.nextUrl();
			}
			
			if(currentUrl==null){
				break;}
			leg.crawl(currentUrl);
			boolean success = leg.searchForWord(searchWord);
			if (success) {
				System.out.println(String.format("**Success** Word %s found at %s", searchWord, currentUrl));
				break;  //this stops it.
			}
			this.pagesToVisit.addAll(leg.getLinks());

		}
		System.out.println(String.format("**Done** Visited %s web page(s)", this.pagesVisited.size()));

	}
	public void mySearch(String url, String searchWord) {
		this.pagesToVisit.add(url);
		MySpiderLeg sl=new MySpiderLeg();
		while (!pagesToVisit.isEmpty() && this.pagesVisited.size() < MAX_PAGES_TO_SEARCH) {

			String currentUrl=nextUrl();
			if (currentUrl==null) break;
			this.pagesVisited.add(currentUrl);
			List<String> links=sl.crawl(currentUrl);
			if (links!=null){
			//this.pagesToVisit.addAll(links);
			for(String urls: links){
				if (!this.pagesVisited.contains(urls)){
					this.pagesToVisit.add(urls);
				}
			}
			}
				boolean success = sl.searchForWord(searchWord);
				if (success) {
					System.out.println(String.format("**Success** Word %s found at %s", searchWord, currentUrl));
					break;
				}
		}
		System.out.println(String.format("**Done** Visited %s web page(s)", this.pagesVisited.size()));
	}
	

	private String nextUrl() {
		String nextUrl;
		do {
			if(!pagesToVisit.isEmpty()){
			nextUrl = this.pagesToVisit.remove();
			} else 
			{return null;}
		} while (this.pagesVisited.contains(nextUrl));
		
		return nextUrl;
	}
}
