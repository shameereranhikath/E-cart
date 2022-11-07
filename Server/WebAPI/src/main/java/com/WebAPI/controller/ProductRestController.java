package com.WebAPI.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.WebAPI.entity.Products;
import com.WebAPI.service.ProductService;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProductRestController {

	@Autowired
	ProductService prdt_serv;
	
	@CrossOrigin(origins = "http://localhost:8080/listproducts")
	@GetMapping("listprdt")   
	public List<Products> listallprdt() throws Exception
	{
		
		return prdt_serv.listprdt();
	}
	
	@CrossOrigin(origins = "http://localhost:8080/addproductlist")
	@RequestMapping(value = "/addprdt", method = RequestMethod.POST,produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })	
	@ResponseBody
	public void addproduct(@RequestBody Products p) throws IOException 
	{			
				
		prdt_serv.addproduct(p)	;	
	}
}
