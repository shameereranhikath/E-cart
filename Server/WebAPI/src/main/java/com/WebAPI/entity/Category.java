package com.WebAPI.entity;
import javax.persistence.*;

@Entity
@Table(name="Category")
public class Category {
	
	@Id
	private int cat_id;
	@Column(name="cat_name")
	 private String cat_name;
	

}
