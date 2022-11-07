package com.WebAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.Spring.products;
import com.WebAPI.Repository.ProductsRepo;
import com.WebAPI.entity.Products;
@Service("prdt_serv")
public class ProductService {

	@Autowired
	ProductsRepo prdt_rep;
	
	public List<Products> listprdt()
	{
		return prdt_rep.findAll();
		                                        
	}
	
	public void addproduct(Products p)
	{
		prdt_rep.saveAndFlush(p);
	}
	
}
