package com.e_todos.apidevelopment3party_todos.Models;

public class Todo extends BaseModel{

    private String todo;
    private Boolean completed;
    private Long userid;

    public Todo() {
    }

    public Todo(String todo, Boolean completed, Long userid) {
        this.todo = todo;
        this.completed = completed;
        this.userid = userid;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }
}
