package com.example.demolab1.exception;

import jakarta.ws.rs.WebApplicationException;

public class IdMissingException extends WebApplicationException {

    public IdMissingException(){
        super();
    }

    public IdMissingException(String message){
        super(message);
    }
}
