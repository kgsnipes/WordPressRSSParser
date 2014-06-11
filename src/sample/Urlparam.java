package sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Urlparam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(getPostId("http://wordpress.groupfmg.com/wordpress/?&p=3331&cat=hel"));
		

	}
	
	
	public static Integer getPostId(final String link)
	{
		Integer postId = -1;
		try
		{
			final String pattern = "([\\?|\\&]{0}[p]=\\w+\\&{0})";

			// Create a Pattern object
			final Pattern r = Pattern.compile(pattern);

			// Now create matcher object.
			final Matcher m = r.matcher(link);
			if (m.find())
			{
				System.out.println(m.group(0));
				postId = new Integer(m.group(0).split("=")[1]);
			}
		}
		catch (final Exception ex)
		{
			postId = -1;
		}
		return postId;
	}


}
