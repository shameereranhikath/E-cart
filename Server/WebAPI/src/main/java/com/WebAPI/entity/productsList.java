package com.WebAPI.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productslist")
public class productsList {
	@Id
	private int prlistid;
	public int getPrlistid() {
		return prlistid;
	}

	public void setPrlistid(int prlistid) {
		this.prlistid = prlistid;
	}

	@Column(name="prid")
	private int prid;
	@Column(name="prnm")
	private String prnm;
	@Column(name="qty")
	private int qty;
	@Column(name="priceperunit")
	private float priceperunit;
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

	public int getPrid() {
		return prid;
	}

	public void setPrid(int prid) {
		this.prid = prid;
	}

	public String getPrnm() {
		return prnm;
	}

	public void setPrnm(String prnm) {
		this.prnm = prnm;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public float getPriceperunit() {
		return priceperunit;
	}

	public void setPriceperunit(float priceperunit) {
		this.priceperunit = priceperunit;
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
	
	public productsList() {}
	
	 public productsList(String prnm,int qty,float priceperunit, String name, String type, byte[] picByte,String description) {
		      this.prnm=prnm;
		      this.qty=qty;
		      this.priceperunit=priceperunit;
		         this.name = name;
		
		         this.type = type;
		
		         this.image = picByte;
		         
		         this.discount = 0;
		         
		         this.description=description;
		
		     }

}
