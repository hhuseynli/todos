package com.Huseyn.todos.model;

import java.sql.Date;

public class Todo {
	private Integer id;
	private String name;
	private Integer day;
	private Date start;
	private Category category;
	private String status;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Todo [id=" + id + ", name=" + name + ", day=" + day + ", start=" + start + ", category=" + category
+ ", status=" + status + "]";
}
	


}
