package com.WebAPI.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WebAPI.entity.Users;
import com.WebAPI.Repository.UsersRepo;
@Service("user_serv")
public class UsersService {
	
	@Autowired
	UsersRepo usr_rep;
	
	public List<Users> listusers()
	{
		return usr_rep.findAll();
	}

}