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
	
	int newId = todoDAO.save(todo);
	todo.setId(newId);
	return todo;
	
}


@RequestMapping(path="/todo",method=RequestMethod.GET)
public List<Todo> getTodos(){
	return todoDAO.findAll();
	
}




@DeleteMapping(path="/{id}")
public void deleteTodoById(@PathVariable(name="id") Integer id){
	for (int i = 0; i < todoDAO.findAll().size(); i++) {
		if(todoDAO.findAll().get(i).getId()==id){
			 todoDAO.deleteSel(id);
		}
	}
	
}
}
