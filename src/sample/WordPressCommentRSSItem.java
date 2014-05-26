package sample;

import java.util.Date;
import java.util.List;

public class WordPressCommentRSSItem {
	
	private String title;
	private String link;
	private Date publishDate;
	private String creator;
	private String guid;
	private String description;
	private String content;
	private List<String> mediaImages;
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
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<String> getMediaImages() {
		return mediaImages;
	}
	public void setMediaImages(List<String> mediaImages) {
		this.mediaImages = mediaImages;
	}
	
	

}
