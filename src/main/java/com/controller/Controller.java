package com.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.Service;
@RestController
public class Controller {
	
	@Autowired
	private Service service;
	
	
	@PostMapping("/query")
	public String query(@RequestBody String query) {
		
		try {
			return service.executeQuery(query);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "FAILED";
	}

}
