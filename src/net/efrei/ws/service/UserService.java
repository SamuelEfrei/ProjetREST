package net.efrei.ws.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.efrei.ws.database.DataBase;
import net.efrei.ws.model.User;

public class UserService {

	private Map<String, User> users = DataBase.getUsers();
	
	public UserService() {
		users.put("dayian", new User(1L,"dayian", "123","Paris"));
		users.put("sebastien", new User(2L,"sebastien","456","Brest"));
		users.put("samuel", new User(3L,"samuel","789","Villejuif"));
		users.put("baptiste", new User(4L,"baptiste","123456","Tourcoing"));
	}
	
	public List<User> getAllUsers(){
		return new ArrayList<User>(users.values());
	}
	
	public User getUser(String username) {
		return users.get(username);
	}
	
	public User addUser(User user) {
		user.setId(users.size() + 1);
		users.put(user.getUsername(), user);
		return user;
	}
	
	public User updateUser(User user) {
		if (user.getUsername().isEmpty()) {
			return null;
		}
		users.put(user.getUsername(), user);
		return user;
	}
	
	public User removeUser(String username) {
		return users.remove(username);
	}
}
