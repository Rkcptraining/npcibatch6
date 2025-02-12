package com.banking1consumer.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.banking1consumer.dto.Employee;

@RestController
@RequestMapping("/api/v1/consumers")
public class ConsumerController {
	
	@GetMapping
	public List<Employee> consumeAllEmployee(){
		
		RestTemplate rtemp=new RestTemplate();
		
		List<Employee> ee=  rtemp.getForObject("http://localhost:10000/api/v1/employees", List.class);
		
		return ee;
	}
	
	@PostMapping
	public String consumecreateEmployee(@RequestBody Employee emp){
		
		RestTemplate rtemp=new RestTemplate();
		
		String ee=  rtemp.postForObject("http://localhost:10000/api/v1/employees",emp, String.class);
		
		return ee;
	}
	
	@PutMapping("/{uid}")
	public String consumeeditEmployee(@PathVariable("uid") String email,@RequestBody Employee emp){
		
		RestTemplate rtemp=new RestTemplate();
		
		rtemp.put("http://localhost:10000/api/v1/employees/"+email,emp);
		
		return "record edited";
	}
	
	@DeleteMapping("/{uid}")
	public String consumedeleteEmployee(@PathVariable("uid") String email){
		
		RestTemplate rtemp=new RestTemplate();
		
		rtemp.delete("http://localhost:10000/api/v1/employees/"+email);
		
		return "record deleted";
	}

}
