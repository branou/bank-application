package dev.himbra.bankapplication.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String mes){
        super(mes);
    }
}
