package com.WebAPI.entity;
import javax.persistence.*;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name="users")
public class Users {
	
	@Id
	private int userid;
//	@Column(name="user_name")
//	private String user_name;
	@Column(name="email")
	private String email;
	@Column(name="pwd")
	private String pwd;
	@Column(name="creationdate")
	private String creationdate;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getCreationdate() {
		return creationdate;
	}
	public void setCreationdate(String creationdate) {
		this.creationdate = creationdate;
	}
}
