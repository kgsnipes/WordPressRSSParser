package sample;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class WPRSSParserUtil {
	
	
	public static String getRSSFeedURL(String domain)
	{
		return getDomain(domain)+"/feed/";
	}
	
	public static String getRSSFeedURLForCategories(String domain,List<String> categories)
	{
		StringBuffer buf=new StringBuffer();
		buf.append("/");
		for(String s:categories)
		{
			buf.append(s+",");
		}
		buf.deleteCharAt(buf.length()-1);

		 return getDomain(domain)+buf.toString()+"/feed/";
	}
	
	public static String getRSSFeedURLForAPost(String postURL)
	{
		
		 return postURL+"feed/?withoutcomments=1";
	}
	
	public static String getDomain(String domain)
	{
		if(domain.endsWith("/"))
			return domain.substring(0, domain.lastIndexOf("/")-1);
		else
			return domain;
	}
	
	public static Document getRSSDocument(String url)
	{
		Document document=null;
		 SAXReader reader = new SAXReader();
		 try
		 {
			 document = reader.read(url);
		 }
		 catch(Exception ex)
		 {
			ex.printStackTrace(); 
		 }
	     
		 return document;  
	}
	
	public static List<WordPressRSSItem> getItems(Document doc)
	{
		List<WordPressRSSItem> retVal=new ArrayList<WordPressRSSItem>();
		 
		 for(Node n:(List<Node>)doc.selectNodes("/rss/channel/item"))
		 {
			 retVal.add(getItem(n));
		 }
		 return retVal;
	}
	
	public static WordPressRSSItem getItem(Node item)
	{
		WordPressRSSItem retVal=new WordPressRSSItem();
		
		retVal.setTitle(getTitle(item));
		retVal.setLink(getLink(item));
		retVal.setCommentLink(getCommentsLink(item));
		retVal.setPublishDate(getPublishDate(item));
		retVal.setCreator(getCreator(item));
		retVal.setCategories(getCategories(item));
		retVal.setGuid(getGuid(item));
		retVal.setDescription(getDescription(item));
		retVal.setContent(getContent(item));
		retVal.setCommentRssLink(getRSSCommentsLink(item));
		retVal.setComments(getCommentsCount(item));
		return retVal;
		
	}
	
	public static String getTitle(Node item)
	{
		String retVal=null;
		if(item.selectSingleNode("title")!=null)
		{
			retVal=item.selectSingleNode("title").getText().trim();
		}
		return retVal;
	}
	
	public static String getLink(Node item)
	{
		String retVal=null;
		if(item.selectSingleNode("link")!=null)
		{
			retVal=item.selectSingleNode("link").getText().trim();
		}
		return retVal;
	}
	
	public static String getCommentsLink(Node item)
	{
		String retVal=null;
		if(item.selectSingleNode("comments")!=null)
		{
			retVal=item.selectSingleNode("comments").getText().trim();
		}
		return retVal;
	}
	
	public static Date getPublishDate(Node item)
	{
		Date retVal=null;
		if(item.selectSingleNode("pubDate")!=null)
		{
			String date=item.selectSingleNode("pubDate").getText().trim();
			DateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
			try {
				retVal = formatter.parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return retVal;
	}
	
	public static String getCreator(Node item)
	{
		String retVal=null;
		if(item.selectSingleNode("dc:creator")!=null)
		{
			retVal=item.selectSingleNode("dc:creator").getText().trim();
		}
		return retVal;
	}
	
	public static List<String> getCategories(Node item)
	{
		List<String> retVal=null;
		if(item.selectNodes("category")!=null && item.selectNodes("category").size()>0)
		{
			retVal=new ArrayList<String>();
			for(Node n:(List<Node>)item.selectNodes("category"))
			{
				retVal.add(n.getText().trim());
			}
			//retVal=item.selectSingleNode("dc:creator").getText().trim();
		}
		return retVal;
	}
	
	public static String getGuid(Node item)
	{
		String retVal=null;
		if(item.selectSingleNode("guid")!=null)
		{
			retVal=item.selectSingleNode("guid").getText().trim();
		}
		return retVal;
	}
	
	public static String getDescription(Node item)
	{
		String retVal=null;
		if(item.selectSingleNode("description")!=null)
		{
			retVal=item.selectSingleNode("description").getText().trim();
		}
		return retVal;
	}

	
	public static String getContent(Node item)
	{
		String retVal=null;
		if(item.selectSingleNode("content:encoded")!=null)
		{
			retVal=item.selectSingleNode("content:encoded").getText().trim();
		}
		return retVal;
	}
	
	public static String getRSSCommentsLink(Node item)
	{
		String retVal=null;
		if(item.selectSingleNode("wfw:commentRss")!=null)
		{
			retVal=item.selectSingleNode("wfw:commentRss").getText().trim();
		}
		return retVal;
	}
	
	public static Integer getCommentsCount(Node item)
	{
		Integer retVal=null;
		if(item.selectSingleNode("slash:comments")!=null)
		{
			retVal=Integer.parseInt(item.selectSingleNode("slash:comments").getText().trim());
		}
		return retVal;
	}


}
