package com.Huseyn.todos.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Huseyn.todos.database.Database;
import com.Huseyn.todos.model.Category;
import com.Huseyn.todos.model.Todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

@Component
public class CategoryDAO {
	@Autowired
	private DataSource source;
	
	public Integer save(Category c){
//		Database.allTodos.add(todo);
		Integer id=0;
		try {
			
			String query="insert into category(name)"+" values (?)";
			Connection con=source.getConnection();
			PreparedStatement statement=con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, c.getName());
			statement.executeUpdate();
			ResultSet res = statement.getGeneratedKeys();
			if(res.next()){
				id= res.getInt(1);
			}
			statement.close();
			con.close();
			res.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return id;
	}
	public List<Category> getCategories(){
	List <Category> list= new ArrayList<>();
	try {
		String query="select * from category";
		Connection con=source.getConnection();
		PreparedStatement statement = con.prepareStatement(query);
		ResultSet res = statement.executeQuery();
		while(res.next()){
			Category c= new Category();
			c.setId(res.getInt("id"));
			c.setName(res.getString("name"));
			list.add(c);
		}
		con.close();
		statement.close();
		res.close();
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return list;
	}
	

}
