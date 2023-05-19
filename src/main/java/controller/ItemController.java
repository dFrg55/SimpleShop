package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.DaoEnum;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.ItemEntity;
import repository.ItemRepository;

import java.util.List;

@Path("item")
@RequestScoped
public class ItemController {
    private final Gson gson = new Gson();
    private final ItemRepository itemRepository = new ItemRepository(DaoEnum.PostgreHiber);


    @Path("getAllItem")
    @GET
    public String getAllItem(){


        List<ItemEntity> users = itemRepository.findAllItem();

        String json = gson.toJson(users);
        return json;
    }


    @Path("secure/saveItem")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response setItem(String jsonItem){
        GsonBuilder builder = new GsonBuilder();
        Gson gsonItem = builder.create();
        try {
            ItemEntity itemEntity = gsonItem.fromJson(jsonItem, ItemEntity.class);
            itemRepository.save(itemEntity);
        }
        catch (Exception e){
            System.out.println(jsonItem+"\n"+e+e.getMessage());
            return Response.serverError().build();
        }
        return Response.ok().build();
    }


    @Path("getOneItem/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String getOneItem(@PathParam("id")String id){
        GsonBuilder builder = new GsonBuilder();
        Gson gsonItem = builder.create();
        return gsonItem.toJson(itemRepository.findItem(Integer.valueOf(id)));
    }
    @RolesAllowed("admin")
    @Path("secure/deleteItem/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteItem(@PathParam("id")String id){
        itemRepository.delete(Integer.valueOf(id));
        return Response.ok().build();
    }
}
