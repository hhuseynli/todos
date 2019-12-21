package com.Huseyn.todos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Huseyn.todos.dao.TodoDAO;
import com.Huseyn.todos.database.Database;
import com.Huseyn.todos.model.Todo;

@RestController  
@RequestMapping(path="/todos")
@CrossOrigin(origins={"http://localhost:4200"})

public class TodoRestController  {
	@Autowired
	private TodoDAO todoDAO;
	
	
@RequestMapping(path="/todo",method=RequestMethod.POST)
public Todo addTodo( @RequestBody Todo todo){
	
	
	int id =Database.allTodos.size()+1;
	todo.setId(id);
	System.out.println(todo);
	todoDAO.save(todo);
	return todo;
	
}
@RequestMapping(path="/todo",method=RequestMethod.GET)
public List<Todo> getAll(){
	return todoDAO.findAll();
	
}
@RequestMapping(path="/todo/{id}",method=RequestMethod.GET)
public Todo getTodoById(@PathVariable(name="id") Integer id){
	return Database.allTodos.get(id);
	
}

@DeleteMapping(path="/{id}")
public void deleteTodoById(@PathVariable(name="id") Integer id){
	for (int i = 0; i < Database.allTodos.size(); i++) {
		if(Database.allTodos.get(i).getId()==id){
			 Database.allTodos.remove(i);
			 break;
		}
	}
	
}
}
