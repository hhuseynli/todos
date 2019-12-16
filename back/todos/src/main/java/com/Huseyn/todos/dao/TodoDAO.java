package com.Huseyn.todos.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.Huseyn.todos.database.Database;
import com.Huseyn.todos.model.Todo;

@Component
public class TodoDAO {
	public void save(Todo todo){
		Database.allTodos.add(todo);
	}
	public  List<Todo> findAll() {
		
		return  Database.allTodos;
	}
	
}
              