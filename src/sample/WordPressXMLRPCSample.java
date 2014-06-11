package sample;

import java.io.IOException;
import java.util.List;

import net.bican.wordpress.Page;
import net.bican.wordpress.PageDefinition;
import net.bican.wordpress.Wordpress;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

public class WordPressXMLRPCSample {

	
	public static void main(String a[]) throws Exception
	{
		
		String username = "admin";
	    String password = "admin123";
	    String xmlRpcUrl = "http://wordpress.groupfmg.com/wordpress/xmlrpc.php";
	    Wordpress wp = new Wordpress(username, password, xmlRpcUrl);
	    List<Page> recentPosts = wp.getRecentPosts(10);
	    System.out.println("Here are the ten recent posts:");
	    Page mypage=null;
	    for (Page page : recentPosts) {
	      System.out.println(page.getPostid() + ":" + page.getTitle());
	      mypage=page;
	    }
	    
	  Wordpress wp1 = new Wordpress("ravi", "ravi123", xmlRpcUrl);
	  wp1.newComment(mypage.getPostid(), null, "this is from java src", "kaushik", "http://wordpress.groupfmg.com/wordpress/", "kgsnipes@gmail.com");
			
	    
	   /* List<PageDefinition> pages = wp.getPageList();
	    System.out.println("Here are the pages:");
	    for (PageDefinition pageDefinition : pages) {
	      System.out.println(pageDefinition.getPage_title());
	    }
	    System.out.println("Posting a test (draft) page from a previous page...");
	    Page recentPost = wp.getRecentPosts(1).get(0);
	    recentPost.setTitle("Test Page");
	    recentPost.setDescription("Test description");
	    String result = wp.newPost(recentPost, false);
	    System.out.println("new post page id: " + result);
	    System.out.println("\nThat's all for now.");*/
		//String username1 = "ravindran.rethinam@gmail.com";
	    //String password1 = "password";
	    //Wordpress wp1 = new Wordpress(username1, password1, xmlRpcUrl);
	   // wp1.newComment(mypage.getPostid(), null, "testing commeniwfjts", "kaushik", "http://geniusglutenfree.wordpress.com/", "kgsnipes@gmail.com");
		
	}
}

