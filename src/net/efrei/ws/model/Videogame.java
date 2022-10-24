package net.efrei.ws.model;

public class Videogame extends Item{
	

	private String gametype;
	private String studio;
	
	public Videogame() {
		
	}
	
	public Videogame(long id, String name, String description, String gametype, String studio, int year) {
		super(id, name, description, year);
		this.gametype = gametype;
		this.studio = studio;
	}
	
	public void setGametype(String gametype) {
		this.gametype = gametype;
	}
	public void setStudio(String studio) {
		this.studio = studio;
	}
	public String getGametype() {
		return gametype;
	}
	public String getStudio() {
		return studio;
	}
	
}
