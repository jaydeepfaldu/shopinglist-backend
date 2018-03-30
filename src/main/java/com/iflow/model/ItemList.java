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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "item_list")
public class ItemList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "list_id")
	private int list_id;
	
	
	@Column(name = "list_title", length = 30)
	private String list_title;
	
	
	@Column(name = "user_id", length = 30)
	private int user_id;
	
	
	
	public  ItemList()
	{
		
	}
	
	public  ItemList(int uid)
	{
		this.user_id = uid;
		
	}
	public ItemList(int lid, String ltit, int user_id)
	{
		this.list_id = lid;
		this.list_title = ltit;
		this.user_id = user_id;
	}
	
	
	
	public int getUser_id()
	{
		return user_id;
	}
	
	public void setUser_id(int uid)
	{
		this.user_id = uid;
	}
	
	public int getList_id()
	{
		return list_id;
	}
	public void setList_id(int iid)
	{
		this.list_id = iid;
	}
	
	public void setList_title(String listtitle)
	{
		this.list_title = listtitle;
	}
	
	public String getList_title()
	{
		return list_title;
	}	
	
}
