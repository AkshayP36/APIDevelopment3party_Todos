package com.e_todos.apidevelopment3party_todos.Controllers;

import com.e_todos.apidevelopment3party_todos.Errors.TodoNotFoundException;
import com.e_todos.apidevelopment3party_todos.Models.Todo;
import com.e_todos.apidevelopment3party_todos.Services.TodoService;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {

    TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todo/{id}")
    private Todo getATodo(@PathVariable("id") Long id) throws TodoNotFoundException {
        return todoService.getATodo(id);
    }
    @GetMapping("/todo")
    private Todo[] getAllTodos() throws TodoNotFoundException{
        return todoService.getAllTodos();
    }
    @PostMapping("/todo")
    private Todo createATodo(Todo todo){
        return todoService.createATodo(todo.getTodo(), todo.getCompleted(), todo.getUserid());
    }
    @PutMapping("/todo/{id}")
    private Todo updateATodo(@PathVariable("id") Long id, Todo todo){
        return todoService.updateATodo(id, todo.getTodo(), todo.getCompleted(), todo.getUserid());
    }
    @DeleteMapping("/todo/{id}")
    private Todo deleteATodo(@PathVariable("id") Long id) throws TodoNotFoundException{
        return todoService.deleteATodo(id);
    }
}
