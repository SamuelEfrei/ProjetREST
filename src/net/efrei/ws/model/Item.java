package net.efrei.ws.model;

public class Item {

	private long id;
	private String name;
	private String description;
	private int year;
	
	public Item() {
		
	}
	
	public Item(long id, String name, String description, int year) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.year = year;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
}
