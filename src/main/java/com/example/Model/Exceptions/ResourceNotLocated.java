package com.example.Model.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotLocated extends RuntimeException {

    public ResourceNotLocated(String message){ super(message);}
}
