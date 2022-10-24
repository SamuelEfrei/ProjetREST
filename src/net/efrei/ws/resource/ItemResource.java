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

import net.efrei.ws.model.Item;
import net.efrei.ws.service.ItemService;

@Path("/items")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItemResource {

	public ItemService itemService = new ItemService();
	
	@GET
	public List<Item> getItems(){
		return itemService.getAllItems();
	}
	
	@POST
	public Item addItem(Item item) {
		return itemService.addItem(item);
	}
	
	@GET
	@Path("/{item}")
	public Item getItem(@PathParam("item") String name) {
		return itemService.getItem(name);
	}
	
	@PUT
	@Path("/{item}")
	public Item updateItem(@PathParam("item") String name, Item item) {
		item.setName(name);
		return itemService.updateItem(item);
	}
	
	@DELETE
	@Path("/{item}")
	public void deleteItem(@PathParam("item") String name) {
		itemService.removeItem(name);
	}
	
}
