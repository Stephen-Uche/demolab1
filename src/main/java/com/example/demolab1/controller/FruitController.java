package com.example.demolab1.controller;

import com.example.demolab1.dto.FruitDto;
import com.example.demolab1.entity.Fruit;
import com.example.demolab1.mapper.FruitMapper;
import com.example.demolab1.repository.FruitRepository;
import com.example.demolab1.validate.FruitValidator;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@Path("/fruits")
public class FruitController {

    @Inject
    FruitRepository repository;

    @Inject
    FruitValidator validator;

    @Inject
    FruitMapper mapper;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<FruitDto> getAll(@QueryParam("name") String name){

        if (name == null)
            return mapper.map(repository.findAll());
        return mapper.map(repository.findAllByName(name));
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
    public Response addOne(@Valid Fruit fruit) {

        //if(!validator.validate(fruit))
            //return Response.status(400,"name can't be null or empty").build();
        repository.insertFruit(fruit);
        return Response.created(URI.create("fruits/" + fruit.getId())).build();
    }

    @DELETE
    @Path("/{id}")
    public void deleteOne(@PathParam("id") Long id) {
        repository.deleteFruit(id);
    }

}
