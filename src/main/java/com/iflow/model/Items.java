package com.iflow.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="items")
public class Items implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "store")
	private String store;

	@Column(name = "qty")
	private int qty;
	
	@Column(name = "eprice")
	private float eprice;
	
	@Column(name = "inbucket")
	private int inbucket;
	
	@Column(name = "sprice")
	private float sprice;

	
	

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public void setEprice(float eprice)
	{
		this.eprice = eprice;
	}
	
	public void setInbucket(int inbucket)
	{
		this.inbucket = inbucket;
	}
	public void setSprice(float sprice)
	{
		this.sprice = sprice;
	}
	
	
	
	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getStore() {
		return this.store;

	}

	public int getQty() {
		return qty;
	}
	public float getEprice()
	{
		return eprice;
	}
	
	public int getInbucket()
	{
		return inbucket;
	}
	public float getSprice()
	{
		return sprice;
	}
}
