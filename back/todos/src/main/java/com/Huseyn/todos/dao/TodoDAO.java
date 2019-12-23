package com.Huseyn.todos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Huseyn.todos.database.Database;
import com.Huseyn.todos.model.Todo;

@Component
public class TodoDAO {
	@Autowired
	private DataSource source;
	
	public Integer save(Todo todo){
//		Database.allTodos.add(todo);
		Integer id=0;
		try {
			
			String query="insert into todo(task,day,category_id) values (?,?,?);";
			Connection con=source.getConnection();
			PreparedStatement statement=con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, todo.getName());
			statement.setInt(2, todo.getDay());
			statement.setInt(3, todo.getCategory().getId());
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
	public  List<Todo> findAll() {
		
		//return  Database.allTodos;
		List<Todo> list = new ArrayList<>();
		try {
			
			String query="SELECT id, task, day, start, status FROM todo";
			Connection con=source.getConnection();
			PreparedStatement statement=con.prepareStatement(query);
			ResultSet res= statement.executeQuery();
			while(res.next()){
				Todo todo=new Todo();
				todo.setId(res.getInt("id"));
				todo.setName(res.getString("task"));
				todo.setDay(res.getInt("day"));
				todo.setStart(res.getDate("start"));
				todo.setStatus(res.getString("status"));
				list.add(todo);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
		

	}
	
}
              