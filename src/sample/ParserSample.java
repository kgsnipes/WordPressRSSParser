package sample;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class ParserSample {

	
	public static void main(String a[]) throws JsonGenerationException, JsonMappingException, IOException
	{
		
		ObjectMapper mapper=new ObjectMapper();
		String url="https://wordpress.org/showcase/feed/";
		String url1="http://ravindranr.wordpress.com/feed/";
		String url2="http://geniusglutenfree.wordpress.com/feed/";
		WPRSSFeed feed=WPRSSParserUtil.getWPRSSFeed(WPRSSParserUtil.getRSSDocument(url2));
		WPRSSCommentFeed comment=WPRSSParserUtil.getWPRSSCommentFeed(WPRSSParserUtil.getRSSDocument(WPRSSParserUtil.getRSSCommentFeedURLForAPost(feed.getItems().get(0).getCommentRssLink())));
		System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(comment));
		
		
		
		
	}
}

