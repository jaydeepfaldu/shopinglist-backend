package com.iflow.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "users")
public class Users {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	
	
	@Column(name = "username", length = 30)
	private String username;
	
	
	@Column(name = "password", length = 30)
	private String password;
	
	
	public Users()
	{
		
	}
	public Users(int uid, String unm)
	{		
		this.user_id = uid;
		this.username = unm;		
	}
	public Users(String unm, String pass)
	{
		this.username = unm;
		this.password = pass;
	}
	
	
	public void setUser_id(int user_id)
	{
		this.user_id = user_id;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}	
	
	public int getUser_id()
	{
		return user_id;
	}
	
	public String getPassword()
	{
		return password;
	}
	public String getUsername()
	{
		return username;
	}
	
	
	
}
