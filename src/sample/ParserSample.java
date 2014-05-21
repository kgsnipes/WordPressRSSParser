package sample;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class ParserSample {

	
	public static void main(String a[]) throws JsonGenerationException, JsonMappingException, IOException
	{
		
		ObjectMapper mapper=new ObjectMapper();
		String url="https://wordpress.org/showcase/feed/";
		System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(WPRSSParserUtil.getItems(WPRSSParserUtil.getRSSDocument(url))));
	}
}

