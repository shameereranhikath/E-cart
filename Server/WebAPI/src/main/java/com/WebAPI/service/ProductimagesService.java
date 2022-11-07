package com.WebAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.WebAPI.entity.Productimages;
import com.WebAPI.Repository.ProductimagesRepo;

@Service("image_serv")
public class ProductimagesService
{
	@Autowired
	ProductimagesRepo image_rep;
	

	public void addimage(Productimages img)
	{
		image_rep.save(img);
	}

	public Optional<Productimages> findByName(String name)
	{
		return image_rep.findByName(name);
	}
	
	public List<Productimages> listimages()
	{
	
		return image_rep.findAll();
	}

}