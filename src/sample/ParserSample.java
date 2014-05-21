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
		System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(WPRSSParserUtil.getItems(WPRSSParserUtil.getRSSDocument(url))));
		
		//String [] cat=new String[]{"hello","hI"};
		//System.out.println(WPRSSParserUtil.getRSSFeedURLForCategories("domain",Arrays.asList(cat)));
		
	}
}

