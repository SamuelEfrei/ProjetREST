package net.efrei.ws.model;


public class Movie extends Item{

	private String length;
	private String director;
	private String actors;

	public Movie() {
		
	}
	
	public Movie(long id, String name, String description, String length, String director, String actors, int year) {
		super(id, name, description, year);
		this.length = length;
		this.director = director;
		this.actors = actors;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public String getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}
	public String getActors() {
		return actors;
	}
	
}