package net.efrei.ws.model;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Base64;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import net.efrei.ws.database.DataBase;


@Provider
@PreMatching
public class SecurityFilter implements ContainerRequestFilter{
	
	private Map<Long, Post> posts = DataBase.getPosts();
	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic";
	private static final String SECURED_URL_PREFIX = "secured";
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException{
		if (requestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)) {
			List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
			if (authHeader != null && authHeader.size() > 0) {
				String authToken = authHeader.get(0);
				authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
				authToken = authToken.trim();
				byte[] decodedBytes = Base64.getDecoder().decode(authToken);
				String decodedString = new String(decodedBytes);
				StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
				String username = tokenizer.nextToken();
				String password = tokenizer.nextToken();
				
				String checker = requestContext.getUriInfo().getPath();
				char a = 0;
				int cpt = 1;
				String res = "";
				while (a != '/') {
					char b = checker.charAt(checker.length() - cpt);
					a = b;
					if (a != '/') {
						res = res + a;
					}else {
						break;
					}
					cpt = cpt + 1;
				}
				StringBuilder in = new StringBuilder();
				in.append(res);
				in.reverse();
				Long l = Long.parseLong(in.toString());
				
				for (Post post : posts.values()) {
					if (post.getUser().getUsername().contentEquals(username) && post.getUser().getPassword().contentEquals(password) && post.getId()==l) {
						return;
					}
				}
				
			}
			Response unauthorizedStatus = Response
											.status(Response.Status.UNAUTHORIZED)
											.entity("User cannot access the resource.")
											.build();
			requestContext.abortWith(unauthorizedStatus);
		}
		
	}
}
