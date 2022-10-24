package net.efrei.ws.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Post {

	private long id;
	private User user;
	private Item item;
	private String category;
	private float rating;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
	private Date created;
	private Map<Long, Comment> comments = new HashMap<>();
	private List<Link> links = new ArrayList<>();
	
	
	public Post() {
		
	}

	public Post(long id, User user, Item item, String category, float rating) {
		super();
		this.id = id;
		this.user = user;
		this.item = item;
		this.category = category;
		this.rating = rating;
		this.created = new Date();
	}

	public Post(long id, User user, Item item, String category, float rating, Date created) {
		super();
		this.id = id;
		this.user = user;
		this.item = item;
		this.category = category;
		this.rating = rating;
		this.created = created;
	}
	
	public void addLink(String url, String rel) {
		Link link = new Link();
		link.setLink(url);;
		link.setRel(rel);
		links.add(link);
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date year) {
		this.created = year;
	}
	public Map<Long, Comment> getComments(){
		return comments;
	}
	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}

}
