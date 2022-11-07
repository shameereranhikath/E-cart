package com.WebAPI.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

//import com.Spring.productimages;
//import com.Spring.productimages;
import com.WebAPI.entity.Productimages;
import com.WebAPI.entity.Products;
import com.WebAPI.service.ProductimagesService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProductimagesRestController {
	@Autowired
	ProductimagesService image_serv;
	
	@CrossOrigin(origins = "http://localhost:4200/aqa")
	@GetMapping("listimages")   
	public List<Productimages> listallimages() throws Exception
	{
		
		return image_serv.listimages();
	}
	
	@CrossOrigin(origins = "http://localhost:8080/addproduct")
	@PostMapping("/upload")
    public BodyBuilder uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {


        System.out.println("Original Image Byte Size - " + file.getBytes().length);

        Productimages img = new Productimages (file.getOriginalFilename(), file.getContentType(),compressBytes(file.getBytes()));

        image_serv.addimage(img);
        
        
        //write image in assets folder
        
			InputStream in = file.getInputStream();
		//	D:\Java\Ecommerce\AutomotiveEcommerce\src\assets
			//Path target = Paths.get("D:\\2022-7795-7796\\Angular13\\NestedComponent_LoginForm\\src\\assets\\"+file.getOriginalFilename());
			Path target = Paths.get("D:\\Java\\Ecommerce\\AutomotiveEcommerce\\src\\assets\\"+file.getOriginalFilename());
			Files.copy(in, target, StandardCopyOption.REPLACE_EXISTING);
			

        	
        return ResponseEntity.status(HttpStatus.OK);

    }
	
	
	@CrossOrigin(origins = "http://localhost:8080/getimage")
    @GetMapping(path = { "/getimage/{imageName}" })

    public Productimages getImage(@PathVariable("imageName") String imageName) throws IOException {

        final Optional<Productimages> retrievedImage = image_serv.findByName(imageName);

        Productimages img = new Productimages(retrievedImage.get().getName(), retrievedImage.get().getType(),

                decompressBytes(retrievedImage.get().getImage()));

        return img;

    }

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
