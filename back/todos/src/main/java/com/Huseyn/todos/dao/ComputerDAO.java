package com.Huseyn.todos.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.Huseyn.todos.database.Database;
import com.Huseyn.todos.model.Computer;

@Component
public class ComputerDAO {
	
	public void save(Computer computer){
		Database.allComputers.add(computer);
	}
	public List<Computer> findAll() {
		
		return  Database.allComputers;
	}

}
