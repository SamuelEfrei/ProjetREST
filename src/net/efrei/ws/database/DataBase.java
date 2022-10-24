package net.efrei.ws.database;

import java.util.HashMap;
import java.util.Map;

import net.efrei.ws.model.Item;
import net.efrei.ws.model.Post;
import net.efrei.ws.model.User;

public class DataBase {
	
    private static Map<Long, Post> posts = new HashMap<>();
	private static Map<String, User> users = new HashMap<>();
	private static Map<String, Item> items = new HashMap<>();
    
    public static Map<String, Item> getItems() {
		return items;
	}

	public static Map<Long, Post> getPosts(){
        return posts;
    }

    public static Map<String, User> getUsers(){
        return users;
    }	
    
}