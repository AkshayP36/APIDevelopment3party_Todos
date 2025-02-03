package com.e_todos.apidevelopment3party_todos.Services;

import com.e_todos.apidevelopment3party_todos.Errors.TodoNotFoundException;
import com.e_todos.apidevelopment3party_todos.Models.Todo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class TodoServiceDummyJSON implements TodoService{

    RestTemplate restTemplate;

    public TodoServiceDummyJSON(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Todo getATodo(Long id) throws TodoNotFoundException {
        Todo todo = restTemplate.getForObject("https://dummyjson.com/todos/"+id,
                Todo.class);
        return todo;
    }

    @Override
    public Todo[] getAllTodos() throws TodoNotFoundException {
        Todo[] todolist = restTemplate.getForObject("https://dummyjson.com/todos", Todo[].class);
        return todolist;
    }

    @Override
    public Todo createATodo(String todo, Boolean completed, Long userid) {
        Todo todoSingle = new Todo();
        todoSingle.setTodo(todo);
        todoSingle.setCompleted(completed);
        todoSingle.setUserid(userid);
        return restTemplate.postForObject("https://dummyjson.com/todos/add",
                todoSingle, Todo.class);

    }

    @Override
    public Todo updateATodo(Long id, String todo, Boolean completed, Long userid) {
        Todo todoSingle = new Todo();
        todoSingle.setId(id);
        todoSingle.setTodo(todo);
        todoSingle.setCompleted(completed);
        todoSingle.setUserid(userid);

        restTemplate.exchange("https://dummyjson.com/todos/"+id,
                HttpMethod.PUT, new HttpEntity<>(todoSingle), Todo.class);
        return todoSingle;
    }

    @Override
    public Todo deleteATodo(Long id) throws TodoNotFoundException {
        Todo res = restTemplate.getForObject("https://dummyjson.com/todos/"+id,
                Todo.class);
        restTemplate.delete("https://dummyjson.com/todos/"+id,
                Todo.class);
        return res;
    }
}
