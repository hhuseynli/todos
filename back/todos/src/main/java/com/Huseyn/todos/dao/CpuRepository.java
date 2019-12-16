package com.Huseyn.todos.dao;

import org.springframework.stereotype.Component;

import az.Huseyn.todos.service.CpuService;
@Component(value="abc")
public class CpuRepository implements CpuService {

	@Override
	public void printYourPower() {
		 System.out.println("AMD");
		
	}

}
