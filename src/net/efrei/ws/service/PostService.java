package net.efrei.ws.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.efrei.ws.database.DataBase;
import net.efrei.ws.model.Item;
import net.efrei.ws.model.Post;
import net.efrei.ws.model.User;

public class PostService {

	private Map<Long, Post> posts = DataBase.getPosts();
	private Map<String, User> users = DataBase.getUsers();
	private Map<String, Item> items = DataBase.getItems();
	
	public PostService() {
		posts.put(1L, new Post(1L, users.get("dayian"), items.get("The Dark Knight: Le Chevalier Noir"),"movie",2.5f));
		posts.put(2L, new Post(2L, users.get("sebastien"), items.get("To kill a mockingbird"),"book",3.5f));
		posts.put(3L, new Post(3L, users.get("baptiste"), items.get("Super Mario Galaxy"),"videogame",4.0f,new Date(1056557417132L)));
		posts.put(4L, new Post(4L, users.get("dayian"), items.get("Harry Potter and the Sorcerer's Stone"),"book",4.5f));
		posts.put(5L, new Post(5L, users.get("samuel"), items.get("The Little Prince"),"book",3.5f));
		posts.put(6L, new Post(6L, users.get("baptiste"), items.get("Le seigneur des anneaux: le retour du roi"),"movie",4.0f,new Date(1056557417132L)));
	}
	
	public ArrayList<Post> getAllPosts(){
		return new ArrayList<Post>(posts.values());
	}
	
	public List<Post> getAllPostsByCity(String city){
		List<Post> postsByCity = new ArrayList<>();
		for (Post post : posts.values()) {
			if (post.getUser().getCity().contentEquals(city)) {
				postsByCity.add(post);
			}
		}
		return postsByCity;
	}
	
	public List<Post> getAllPostsByKeyword(String keyword){
		List<Post> postsByKeyword = new ArrayList<>();
		for (Post post : posts.values()) {
			if (post.getUser().getUsername().toUpperCase().indexOf(keyword.toUpperCase()) != -1
					|| post.getUser().getCity().toUpperCase().indexOf(keyword.toUpperCase()) != -1
					|| post.getCategory().toUpperCase().indexOf(keyword.toUpperCase()) != -1
					|| post.getItem().getName().toUpperCase().indexOf(keyword.toUpperCase()) != -1
					|| post.getItem().getDescription().toUpperCase().indexOf(keyword.toUpperCase()) != -1){
				postsByKeyword.add(post);
			}
		}
		return postsByKeyword;		
	}
	public List<Post> getAllPostsByUsername(String username){
		List<Post> postsByUsername = new ArrayList<>();
		for (Post post : posts.values()) {
			if (post.getUser().getUsername().contentEquals(username)) {
				postsByUsername.add(post);
			}
		}
		return postsByUsername;
	}
	public List<Post> getAllPostsByCategory(String category){
		List<Post> postsByCategory = new ArrayList<>();
		for (Post post : posts.values()) {
			if (post.getCategory().contentEquals(category)) {
				postsByCategory.add(post);
			}
		}
		return postsByCategory;
	}
	
	public List<Post> getAllPostsForYear(int year){
		List<Post> postsForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (Post post : posts.values()) {
			cal.setTime(post.getCreated());
			if (cal.get(Calendar.YEAR)== year) {
				postsForYear.add(post);
			}
		}
		return postsForYear;
	}
	
	public List<Post> getAllPostsPaginated(int start, int size){
		ArrayList<Post> list = new ArrayList<Post>(posts.values());
		if (start + size > list.size()) return new ArrayList<Post>();
		return list.subList(start,  start + size);
	}
	
	public Post getPost(long id) {
		return posts.get(id);
	}
	
	public Post addPost(Post post) {
		post.setId(posts.size() + 1);
		posts.put(post.getId(), post);
		return post;
	}
	
	public Post updatePost(Post post) {
		if (post.getId() <= 0) {
			return null;
		}
		posts.put(post.getId(), post);
		return post;
	}
	
	public Post removePost(long id) {
		return posts.remove(id);
	}
}
