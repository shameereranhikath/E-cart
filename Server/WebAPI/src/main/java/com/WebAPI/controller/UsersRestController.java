package com.WebAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WebAPI.entity.Users;
import com.WebAPI.service.UsersService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UsersRestController {

	@Autowired
	UsersService user_serv;
	

	@ExceptionHandler({Exception.class})
	@CrossOrigin(origins= "http://localhost:8080/listusers")
	@GetMapping("listusers")   // endpoint name - listuser
	public List<Users> listallusers()
	{
		return user_serv.listusers();
	}
}
