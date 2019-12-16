package com.Huseyn.todos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Huseyn.todos.dao.ComputerDAO;
import com.Huseyn.todos.dao.CpuDAO;
import com.Huseyn.todos.database.Database;
import com.Huseyn.todos.model.Computer;

import az.Huseyn.todos.service.CpuService;

@RestController  
@RequestMapping(path="/students")
public class TestRestController{
	
	@Autowired
	private ComputerDAO computerDAO;//=new ComputerDAO()
	

	@Autowired
	private CpuDAO cpuDAO;
	
	@Autowired
	@Qualifier("abc")
	private CpuService cpuService;
	
	 public TestRestController() {
		
	}


	
	@RequestMapping(path="/name",method=RequestMethod.GET)
public String getStudentName(){
		cpuService.printYourPower();
		return "Huseyn"; 
	}
	@RequestMapping(path="/surname",method=RequestMethod.GET)
	public String getStudentSurname(){
			return "Huseynli";
		}
	@RequestMapping(path="/computer",method=RequestMethod.GET)
	public Computer getComputer(){
			Computer computer=new Computer();
 			computer.setName("Lenovo");
			computer.setCPU("Intel core I7 5th generation");
			computer.setRAM("4+4GB");
			computer.setGPU("Intel HD Graphics + AMD"); 
			computer.setMotherBoard("Lenovo Motherboard");
			computer.setFan("Lenovo Fan");
			
			return computer;
		}
	@RequestMapping(path="/computers",method=RequestMethod.GET)
	public List<Computer> getComputers(){
			
			return computerDAO.findAll();
		}
	@RequestMapping(path="/computer",method=RequestMethod.POST)
	public void AddComputer(@RequestBody Computer computer){
	computerDAO.save(computer);
		
	}
	@RequestMapping(path="/computers/{id}",method=RequestMethod.GET)
	public Computer getComputerById( @PathVariable(name="id") Integer id){
		return Database.allComputers.get(id);
		
	}

@RequestMapping(path="/computers/{id}",method=RequestMethod.DELETE)
public void deleteComputerById( @PathVariable(name="id") Integer id){
	Database.allComputers.remove(id);
	
}
}
 
