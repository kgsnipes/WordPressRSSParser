package sample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParserSample {

	
	public static void main(String a[]) throws JsonGenerationException, JsonMappingException, IOException
	{
		
		ObjectMapper mapper=new ObjectMapper();
		String url="https://wordpress.org/showcase/feed/";
		String url1="http://ravindranr.wordpress.com/feed/";
		String url2="http://geniusglutenfree.wordpress.com/feed/";
		WPRSSFeed feed=WPRSSParserUtil.getWPRSSFeed(WPRSSParserUtil.getRSSDocument(url2));
		System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(feed));
		System.out.println(feed.getItems().get(1).getContent());
		
		WPRSSCommentFeed comment=WPRSSParserUtil.getWPRSSCommentFeed(WPRSSParserUtil.getRSSDocument(WPRSSParserUtil.getRSSCommentFeedURLForAPost(feed.getItems().get(1).getCommentRssLink())));
		System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(comment));
		System.out.println(comment.getItems().get(0).getContent());
		
		
		}
	

	
	public static List<String> getImagesFromContent(String content)
	{
		List<String> images=new ArrayList<String>();
		String temp="<html><head><title></title></head><body>"+content+"</body></html>";
		org.jsoup.nodes.Document doc = Jsoup.parse(temp);
		Elements newsHeadlines = doc.select("img");
		Iterator<Element> it=newsHeadlines.iterator();
		while(it.hasNext())
		{
			Element ele=it.next();
			if(ele.attr("src")!=null && !ele.attr("src").trim().isEmpty())
			{
				images.add(ele.attr("src"));
			}
			
		}
		
		return images;
	}
	
	public static String removeFirstImageFromPostContent(String content)
	{
		String temp="<html><head><title></title></head><body>"+content+"</body></html>";
		org.jsoup.nodes.Document doc = Jsoup.parse(temp);
		 doc.select("img").first().remove();
		return doc.select("body").html();
		
	}
		
}

