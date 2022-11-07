package com.WebAPI.entity;
import javax.persistence.*;

@Entity
@Table(name="products")
public class Products
{

//@GeneratedValue
	@Id
private int prid;
@Column(name="prnm")
private String prnm;
@Column(name="qty")
private int qty;
@Column(name="priceperunit")
private int priceperunit;

@Column(name="description")
private String description;



public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
/*@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
@JsonBackReference
private orderprdt or;

public orderprdt getOr() {
	return or;
}
public void setOr(orderprdt or) {
	this.or = or;
}*/
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
public int getPriceperunit() {
	return priceperunit;
}
public void setPriceperunit(int priceperunit) {
	this.priceperunit = priceperunit;
}




}
//@Entity
//@Table(name="products")
//public class Products {
//@Id
//private int Productid;
//@Column(name="title")
//private String Title;
//@Column(name="Price")
//private float  Price;
//@Column(name="Description")
//private String Description;
//
//@OneToOne(cascade = CascadeType.ALL)
//@JoinColumn(name = "Category_id", referencedColumnName = "cat_id")
//private Category category;
//@Column(name="image")
//private byte[] image;
//@Column(name="rating")
//private float  rating;
//@Column(name="count")
//private int count;
//public int getProductid() {
//	return Productid;
//}
//public void setProductid(int productid) {
//	Productid = productid;
//}
//public String getTitle() {
//	return Title;
//}
//public void setTitle(String title) {
//	Title = title;
//}
//public float getPrice() {
//	return Price;
//}
//public void setPrice(float price) {
//	Price = price;
//}
//public String getDescription() {
//	return Description;
//}
//public void setDescription(String description) {
//	Description = description;
//}
//public Category getCategory() {
//	return category;
//}
//public void setCategory(Category category) {
//	this.category = category;
//}
//public byte[] getImage() {
//	return image;
//}
//public void setImage(byte[] image) {
//	this.image = image;
//}
//public float getRating() {
//	return rating;
//}
//public void setRating(float rating) {
//	this.rating = rating;
//}
//public int getCount() {
//	return count;
//}
//public void setCount(int count) {
//	this.count = count;
//}
//}
