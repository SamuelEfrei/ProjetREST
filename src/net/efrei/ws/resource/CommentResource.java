package net.efrei.ws.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.efrei.ws.model.Comment;
import net.efrei.ws.service.CommentService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class CommentResource {

	private CommentService commentService = new CommentService();
	
	@GET
	public List<Comment> getAllComments(@PathParam("postId") long postId) {
		return commentService.getAllComments(postId);
	}
	
	@POST
	public Comment addPost(@PathParam("postId") long postId, Comment comment) {
		return commentService.addComment(postId, comment);
	}
	
	@PUT
	@Path("/secured/{commentId}")
	public Comment updatePost(@PathParam("postId") long postId, @PathParam("commentId") long commentId, Comment comment) {
		comment.setId(commentId);
		return commentService.updateComment(postId, comment);
	}
	
	@DELETE
	@Path("/secured/{commentId}")
	public void deleteComment(@PathParam("postId") long postId, @PathParam("commentId") long commentId) {
		commentService.removeComment(postId, commentId);
	}
	
	@GET
	@Path("/{commentId}")
	public Comment getPost(@PathParam("postId") long postId, @PathParam("commentId") long commentId) {
		return commentService.getComment(postId, commentId);
	}
}
