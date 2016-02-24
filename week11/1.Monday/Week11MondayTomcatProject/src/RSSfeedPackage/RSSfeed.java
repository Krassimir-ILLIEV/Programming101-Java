package RSSfeedPackage;

import java.io.FileWriter;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sun.syndication.feed.synd.SyndCategory;
import com.sun.syndication.feed.synd.SyndCategoryImpl;
import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndContentImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndFeedImpl;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.SyndFeedOutput;
import com.sun.syndication.io.XmlReader;

public class RSSfeed {

	
	public static void main(String args[]){
		SyndFeed feed = new SyndFeedImpl();
        feed.setFeedType("rss_1.0");
        feed.setTitle("MyProject Build Results");
        feed.setLink("http://myproject.mycompany.com/continuum");
        feed.setDescription("Continuous build results for the MyProject project");    
        feed.setCategory("MyProject");
        
    	SyndEntry entry = new SyndEntryImpl();
        entry.setTitle("BUILD SUCCESSFUL");
        entry.setLink("http://myproject.mycompany.com/continuum/build-results-1");
        entry.setPublishedDate(new Date());
        
        SyndContent description = new SyndContentImpl();
        description.setType("text/html");
        description.setValue("The build was successful!");
        entry.setDescription(description);
        
        List<SyndCategory> categories = new ArrayList<SyndCategory>();
        SyndCategory category = new SyndCategoryImpl();
        category.setName("MyProject");
        categories.add(category);
        entry.setCategories(categories);
        
        feed.setEntries(entries);
        
        Writer writer = new FileWriter("stream.xml");
        SyndFeedOutput output = new SyndFeedOutput();
        output.output(feed,writer);
      writer.close();
      
      URL feedSource = new URL("http://some.rss.feed");
      SyndFeedInput input = new SyndFeedInput();
      SyndFeed feed = input.build(new XmlReader(feedSource));
	}
	

}
