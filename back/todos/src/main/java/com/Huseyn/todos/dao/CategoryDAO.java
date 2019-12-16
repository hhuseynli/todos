package com.Huseyn.todos.dao;

import org.springframework.stereotype.Component;

import com.Huseyn.todos.database.Database;
import com.Huseyn.todos.model.Category;


import java.util.List;

@Component
public class CategoryDAO {
	
	public void save(Category category){
		Database.allCategories.add(category);
	}
	public List<Category> getCategories(){
	return Database.allCategories ;
	}
	

}
