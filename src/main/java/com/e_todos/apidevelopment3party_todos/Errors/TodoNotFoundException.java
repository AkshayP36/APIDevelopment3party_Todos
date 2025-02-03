package com.e_todos.apidevelopment3party_todos.Errors;

public class TodoNotFoundException extends Exception{

    public TodoNotFoundException(String message){
        super(message);
    }
}
