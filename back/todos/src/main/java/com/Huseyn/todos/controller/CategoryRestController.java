package com.Huseyn.todos.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Huseyn.todos.dao.CategoryDAO;
import com.Huseyn.todos.database.Database;
import com.Huseyn.todos.model.Category;

@RestController
@RequestMapping(path="/categories")
@CrossOrigin(origins={"http://localhost:4200"})
public class CategoryRestController {
	@Autowired
	private CategoryDAO categoryDao;
	
	
	@RequestMapping(path="/category", method=RequestMethod.GET)	
	public List <Category> getAll(){
		return categoryDao.getCategories();
		
	}

	@RequestMapping(path="/category", method=RequestMethod.POST)	
	public Integer addCategory(@RequestBody Category category){
		Integer newId=  categoryDao.save(category);
		category.setId(newId);
		return newId;
		
		
		
	}

}
