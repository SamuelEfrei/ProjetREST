package net.efrei.ws.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.efrei.ws.database.DataBase;
import net.efrei.ws.model.Comment;
import net.efrei.ws.model.Post;

public class CommentService {

	private Map<Long, Post> posts = DataBase.getPosts();
	
	public CommentService() {
		addComment(1L, new Comment(1L, "This is good!", "Adams"));
		addComment(2L, new Comment(2L, "This is bad!", "Baker"));
		addComment(3L, new Comment(3L, "I love it!", "Clark"));
		addComment(4L, new Comment(4L, "Please don't.", "Davis"));
		addComment(1L, new Comment(5L, "OMG!", "Evans"));
		addComment(2L, new Comment(6L, "Actually, this does not respect the author's vision....", "Frank"));
		addComment(3L, new Comment(7L, "Nous ronpichames", "Ghosh"));
		addComment(4L, new Comment(8L, "Pourquoi une si bonne note?", "Hills"));
		addComment(1L, new Comment(9L, "Plutot OK", "Irwin"));
		addComment(2L, new Comment(10L, "J'adorerais l'avoir!", "Jones"));
		addComment(3L, new Comment(11L, "Très intéressant.", "Klein"));
		addComment(4L, new Comment(12L, "Je préfère l'autre version.", "Lopez"));
		addComment(1L, new Comment(13L, "This is good!", "Mason"));
		addComment(2L, new Comment(14L, "This is good!", "Nalty"));
		addComment(3L, new Comment(15L, "This is good!", "Ochoa"));
	}
	
	public List<Comment> getAllComments(long postId){
		Map<Long, Comment> comments = posts.get(postId).getComments();
		return new ArrayList<Comment>(comments.values());
	}
	
	public Comment getComment(long postId, long commentId) {
		Map<Long, Comment> comments = posts.get(postId).getComments();
		return comments.get(commentId);
	}
	
	public Comment addComment(long postId, Comment comment) {
		Map<Long, Comment> comments = posts.get(postId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateComment(long postId, Comment comment) {
		Map<Long, Comment> comments = posts.get(postId).getComments();
		if (comment.getId() <= 0) {
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment removeComment(long postId, long commentId) {
		Map<Long, Comment> comments = posts.get(postId).getComments();
		return comments.remove(commentId);
	}
}
