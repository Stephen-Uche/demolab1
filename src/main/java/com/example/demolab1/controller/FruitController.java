package com.example.demolab1.controller;

import com.example.demolab1.entity.Fruit;
import com.example.demolab1.repository.FruitRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/fruits")
public class FruitController {

    @Inject
    FruitRepository repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fruit> getAll(@QueryParam("name") String name){

        if (name == null)
            return repository.findAll();
        return repository.findAllByName(name);
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOne(@PathParam("id") Long id) {
        var fruit = repository.findOne(id);
        if (fruit.isPresent())
            return Response.ok().entity(fruit.get()).build();
        return Response.status(404).build();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addOne(Fruit fruit) {
        repository.insertFruit(fruit);
    }

    @DELETE
    @Path("/{id}")
    public void deleteOne(@PathParam("id") Long id) {
        repository.deleteFruit(id);
    }

}
