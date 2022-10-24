package net.efrei.ws.model;

public class Book extends Item{
	
	private String author;
	private String genre;

	public Book() {
		
	}
	
	public Book(long id, String name, String description, String author, String genre, int year) {
		super(id, name, description, year);
		this.author = author;
		this.genre = genre;
	}
	public String getAuthor() {
		return author;
	}
	public String getGenre() {
		return genre;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
}
