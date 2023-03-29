package com.example.demolab1.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class IdMissingExceptionMapper implements ExceptionMapper<IdMissingException> {

    @Override
    public Response toResponse(IdMissingException e) {
        return Response.status(404).entity(e.getMessage()).build();
    }
}
