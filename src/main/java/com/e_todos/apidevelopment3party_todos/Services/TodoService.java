package com.e_todos.apidevelopment3party_todos.Services;

import com.e_todos.apidevelopment3party_todos.Errors.TodoNotFoundException;
import com.e_todos.apidevelopment3party_todos.Models.Todo;

public interface TodoService {

    Todo getATodo(Long id) throws TodoNotFoundException;
    Todo[] getAllTodos() throws TodoNotFoundException;
    Todo createATodo(String todo, Boolean completed, Long userid);
    Todo updateATodo(Long id, String todo, Boolean completed, Long userid);
    Todo deleteATodo(Long id) throws TodoNotFoundException;
}
