package com.example.Model.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This is a custom exception for template purposes
 */
@ResponseStatus(value = HttpStatus.I_AM_A_TEAPOT)
public class UnsupportedMethodException extends RuntimeException{

    public UnsupportedMethodException(String message){super(message);}
}
