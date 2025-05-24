package com.curso.services.exceptions;

import org.yaml.snakeyaml.events.Event;

public class ObjectNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String message, Throwable cause){
        super(message, cause);
    }

    public ObjectNotFoundException(String message){
        super(message);
    }

}
