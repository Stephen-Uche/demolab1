package com.example.demolab1.controller;

import com.example.demolab1.dto.FruitDto;
import com.example.demolab1.entity.Fruit;
import com.example.demolab1.mapper.FruitMapper;
import com.example.demolab1.repository.FruitRepository;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return Fruit Object",
            content = @Content(schema = @Schema(implementation = FruitDto.class))),
            @ApiResponse(responseCode = "404", description = "Id Not Found")})
    public Response getOne(@PathParam("id") Long id) {
        var fruit = repository.findOne(id);
        if (fruit.isPresent())
            return Response.ok().entity(fruit.get()).build();
        //return Response.status(404).build();
        //throw new IdMissingException("message" + id);
        throw new NotFoundException("Id" + id);
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
