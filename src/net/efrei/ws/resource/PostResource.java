package net.efrei.ws.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import net.efrei.ws.model.Post;
import net.efrei.ws.service.ItemService;
import net.efrei.ws.service.PostService;
import net.efrei.ws.service.UserService;

@Path("/posts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PostResource {

	public UserService userService = new UserService();
	public ItemService itemService = new ItemService();
	public PostService postService = new PostService();

	@GET
	public ArrayList<Post> getPosts(){
		return postService.getAllPosts();
	}
	
	@GET
	@Path("/searchyear")
	public List<Post> getPostsSorted(@QueryParam("year") int year) {
		if (year > 0) {
			return postService.getAllPostsForYear(year);
		}
		return postService.getAllPosts();
	}
	@GET
	@Path("/searchsample")
	public List<Post> getPostsSorted(@QueryParam("start") int start,
									@QueryParam("size") int size) {

		if (start >= 0 && size >= 0) {
			return postService.getAllPostsPaginated(start, size);
		}
		return postService.getAllPosts();
	}
	@GET
	@Path("/searchcategory")
	public List<Post> getPostsSortedC(@QueryParam("category") String category) {
		if (category != "") {
			return postService.getAllPostsByCategory(category);
		}
		return postService.getAllPosts();
	}

	@GET
	@Path("/searchcity")
	public List<Post> getPostsSortedCi(@QueryParam("city") String city) {
		if (city != "") {
			return postService.getAllPostsByCity(city);
		}
		return postService.getAllPosts();
	}
	@GET
	@Path("/searchkeyword")
	public List<Post> getPostsSortedK(@QueryParam("keyword") String keyword) {
		if (keyword != "") {
			return postService.getAllPostsByKeyword(keyword);
		}
		return postService.getAllPosts();
	}
	@GET
	@Path("/searchusername")
	public List<Post> getPostsSortedU(@QueryParam("username") String username) {
		if (username != "") {
			return postService.getAllPostsByUsername(username);
		}
		return postService.getAllPosts();
	}
	
	@POST
	public Post addPost(Post post) {
		return postService.addPost(post);
	}
	
	@PUT
	@Path("/secured/{postId}")
	public Post updatePost(@PathParam("postId") long postId, Post post) {
		post.setId(postId);
		return postService.updatePost(post);
	}
	
	@DELETE
	@Path("/secured/{postId}")
	public void deletePost(@PathParam("postId") long postId) {
		postService.removePost(postId);
	}
	
	@GET
	@Path("/{postId}")
	public Post getPost(@PathParam("postId") long postId, @Context UriInfo uriInfo) {
		Post post = postService.getPost(postId);
		post.addLink(getUriForSelf(uriInfo, post), "self");
		//post.addLink(getUriForItem(uriInfo, post), "item");
		post.addLink(getUriForUser(uriInfo, post), "user");
		post.addLink(getUriForComments(uriInfo, post), "comments");
		return post;
	}
	
	/*private String getUriForItem(UriInfo uriInfo, Post post) {
		URI uri = uriInfo.getBaseUriBuilder()
				.path(ItemResource.class)
				.path(post.getItem().getName())
				.build();
		return uri.toString();
	}*/
	
	private String getUriForComments(UriInfo uriInfo, Post post) {
		URI uri = uriInfo.getBaseUriBuilder()
				.path(PostResource.class)
				.path(PostResource.class, "getCommentResource")
				.path(CommentResource.class)
				.resolveTemplate("postId", post.getId())
				.build();
		return uri.toString();
	}

	private String getUriForUser(UriInfo uriInfo, Post post) {
		URI uri = uriInfo.getBaseUriBuilder()
				.path(UserResource.class)
				.path(post.getUser().getUsername())
				.build();
		return uri.toString();
	}

	private String getUriForSelf(UriInfo uriInfo, Post post) {
		String uri = uriInfo.getBaseUriBuilder()
			.path(PostResource.class)
			.path(Long.toString(post.getId()))
			.build()
			.toString();
		return uri;
	}
	
	@Path("/{postId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}
	
}
