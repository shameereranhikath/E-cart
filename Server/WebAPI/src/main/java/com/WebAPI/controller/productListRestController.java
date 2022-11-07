package com.WebAPI.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.WebAPI.entity.Products;
//import com.WebAPI.entity.Products;
import com.WebAPI.entity.productsList;
import com.WebAPI.service.productsListService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class productListRestController {
	
	@Autowired
	productsListService prdtlist_serv;
	
	
	@CrossOrigin(origins = "http://localhost:8080/listproductsall")
	@GetMapping("listprdtall")   
	public List<productsList> listallprdtall() throws Exception
	{
		
		return prdtlist_serv.listprdt();
	}
	
//	@Autowired
//	ImageRepository imageRepository;

//	@PostMapping("/upload1")
//	public BodyBuilder uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
//
//		System.out.println("Original Image Byte Size - " + file.getBytes().length);
//		productsList img = new productsList(file.getOriginalFilename(), file.getContentType(),
//				compressZLib(file.getBytes()));
//		prdtlist.save(img);
//		return ResponseEntity.status(HttpStatus.OK);
//	}
	
//	@CrossOrigin(origins = "http://localhost:8080/addproductlist1")
//	//@RequestMapping(value = "/addprdt", method = RequestMethod.POST,produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })	
//	@PostMapping("/upload1")
//    public BodyBuilder uploadImage(@RequestBody productsList p,@RequestParam("imageFile") MultipartFile file) throws IOException {
//
//
//        System.out.println("Original Image Byte Size - " + file.getBytes().length);
//        
//        
//
//        productsList img = new productsList (p.getPrnm(),p.getQty(),p.getPriceperunit(),p.getDescription(),file.getOriginalFilename(), compressBytes(file.getBytes()),file.getContentType());
//
//        prdtlist_serv.addproduct(img);
//        
//        
//        //write image in assets folder
//        
//			InputStream in = file.getInputStream();
//		//	D:\Java\Ecommerce\AutomotiveEcommerce\src\assets
//			//Path target = Paths.get("D:\\2022-7795-7796\\Angular13\\NestedComponent_LoginForm\\src\\assets\\"+file.getOriginalFilename());
//			Path target = Paths.get("D:\\Java\\Ecommerce\\AutomotiveEcommerce - Copy (2)\\src\\assets\\"+file.getOriginalFilename());
//			Files.copy(in, target, StandardCopyOption.REPLACE_EXISTING);
//			
//
//        	
//        return ResponseEntity.status(HttpStatus.OK);
//
//    }
	
	
	 // compress the image bytes before storing it in the database

    public static byte[] compressBytes(byte[] data) {

        Deflater deflater = new Deflater();

        deflater.setInput(data);

        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

        byte[] buffer = new byte[1024];

        while (!deflater.finished()) {

            int count = deflater.deflate(buffer);

            outputStream.write(buffer, 0, count);

        }

        try {

            outputStream.close();

        } catch (IOException e) {

        }

        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

        return outputStream.toByteArray();

    }
    
    
    // uncompress the image bytes before returning it to the angular application

    public static byte[] decompressBytes(byte[] data) {

        Inflater inflater = new Inflater();

        inflater.setInput(data);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

        byte[] buffer = new byte[1024];

        try {

            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);

                outputStream.write(buffer, 0, count);

            }

            outputStream.close();

        } catch (IOException ioe) {

        } catch (DataFormatException e) {

        }

        return outputStream.toByteArray();

    }


}
