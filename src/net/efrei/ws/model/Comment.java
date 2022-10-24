package net.efrei.ws.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Comment {

	private long id;
	private String message;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
	private Date created;
	private String author;
	
	public Comment() {
		
	}

	public Comment(long id, String message, String author) {
		super();
		this.id = id;
		this.message = message;
		this.created = new Date();
		this.author = author;
	}
	
	public Comment(long id, String message, String author, Date date) {
		super();
		this.id = id;
		this.message = message;
		this.created = date;
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
}
