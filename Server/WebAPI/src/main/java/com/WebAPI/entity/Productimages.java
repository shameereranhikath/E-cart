package com.WebAPI.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="productimages")
public class Productimages {

//	@Id	
//	@Column(name = "primary_key_id")
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chat_seq_gen")
//	@SequenceGenerator(name = "chat_seq_gen", sequenceName = "chat_seq")
	//@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	//@GeneratedValue
	@Id
	private int prid;
	@Column(name="image")
	private byte[] image;
	
	@Column(name="discount")
	private int discount;
	
	@Column(name="name")
	private String name;
	
	@Column(name="type")
	private String type;
	
	@Column(name="description")
	private String description;
	
	
	public Productimages() {}
	
	 public Productimages(String name, String type, byte[] picByte) {
		
		         this.name = name;
		
		         this.type = type;
		
		         this.image = picByte;
		         
		         this.discount = 0;
		         
		         this.description="";
		
		     }
	
	

	public int getPrid() {
		return prid;
	}

	public void setPrid(int prid) {
		this.prid = prid;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
