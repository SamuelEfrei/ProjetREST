package net.efrei.ws.model;

public class User {
	
	private long id;
	private String username;
	private String password;
	private String city;	

	public User() {
		
	}
	
	public User(long id, String username, String password, String city) 
	{
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.city = city;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	public String getUsername() {
		return username;
	}

	public String getCity() {
		return city;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
