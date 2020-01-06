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

import com.Huseyn.todos.model.Category;
import com.Huseyn.todos.model.Todo;

@Component
public class TodoDAO {
	@Autowired
	private DataSource source;
	
	public Integer save(Todo todo){
//		Database.allTodos.add(todo);
		Integer id=0;
		try {
			
			
			Connection con=source.getConnection();
			PreparedStatement statement=null;
			ResultSet res=null;
			
			if(todo.getId()>0){
				String query="update todo set task=?,day=?,start=?,category_id=? where id= "+todo.getId();
				statement=con.prepareStatement(query);
				statement.setString(1,todo.getName());
				statement.setInt(2, todo.getDay());
				statement.setDate(3, todo.getStart());
				statement.setInt(4, todo.getCategory().getId());
				statement.executeUpdate();
				
			}else{
				String query="insert into todo(task,day,category_id)"+" values (?,?,?)";
				statement=con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, todo.getName());
				statement.setInt(2, todo.getDay());
				statement.setInt(3, todo.getCategory().getId());
				statement.executeUpdate();
				 res = statement.getGeneratedKeys();
				while(res.next()){
					id= res.getInt(1);
				}
			
			}
			
			statement.close();
			con.close();
			if(res!=null){
			res.close();
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return id;
		
	}
	public  List<Todo> findAll() {
		List<Todo> list = new ArrayList<>();
		try {
			
			String query="SELECT * FROM todo_view ";
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
				Category c = new Category();
				c.setId(res.getInt("category_id"));
				c.setName(res.getString("category_name"));
				todo.setCategory(c);
				list.add(todo);
			}
			statement.close();
			con.close();
			res.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
		

	}
	public void deleteSel(Integer i) {
		try {
				String query="DELETE FROM spring_ng_huseyn_todos.todo WHERE id = "+i;
				Connection con= source.getConnection();
				PreparedStatement statement= con.prepareStatement(query);
				statement.executeUpdate();
				statement.close();
				con.close();
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void changeStatus(Integer id, String status) {
		try {
			String query = "update spring_ng_huseyn_todos.todo set status = '"+status+"' where id = "+id;
			Connection con  = source.getConnection();
			PreparedStatement statement= con.prepareStatement(query);
			statement.executeUpdate();
			statement.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
}
              