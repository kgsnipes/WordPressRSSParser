package sample;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class WPRSSFeed {
	
	private String title;
	private String link;
	private String description;
	private Date lastBuildDate;
	private String language;
	private Set<String> categories;
	private List<WordPressRSSItem> items;
	private Date dateAdded;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getLastBuildDate() {
		return lastBuildDate;
	}
	public void setLastBuildDate(Date lastBuildDate) {
		this.lastBuildDate = lastBuildDate;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Set<String> getCategories() {
		return categories;
	}
	public void setCategories(Set<String> categories) {
		this.categories = categories;
	}
	public List<WordPressRSSItem> getItems() {
		return items;
	}
	public void setItems(List<WordPressRSSItem> items) {
		this.items = items;
	}
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	

}
