package com.Huseyn.todos.dao;

import org.springframework.stereotype.Component;

import com.Huseyn.todos.service.CpuService;


@Component
public class CpuDAO implements CpuService{
	public void printYourPower(){
		System.out.println("Core I9");
	}

}
