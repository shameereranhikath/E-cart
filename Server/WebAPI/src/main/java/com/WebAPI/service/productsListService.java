package com.WebAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WebAPI.Repository.productsListRepo;
import com.WebAPI.entity.productsList;
@Service("prdtlist_serv")
public class productsListService {
	@Autowired
	productsListRepo prdtlist_rep;
	
	public List<productsList> listprdt()
	{
		return prdtlist_rep.findAll();
		                                        
	}
	
	public void addproduct(productsList p)
	{
		prdtlist_rep.saveAndFlush(p);
	}
}
