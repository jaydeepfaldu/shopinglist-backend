package com.iflow.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="list_container")
public class Items{

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "container_id")
	private int container_id;

	@Column(name = "item_name")
	private String item_name;

	@Column(name = "store_name")
	private String store_name;

	@Column(name = "qty")
	private int qty;
	
	@Column(name = "eprise")
	private float eprise;
	
	@Column(name = "inbucket")
	private int inbucket;
	
	@Column(name = "sprise")
	private float sprise;
	
	@Column(name = "list_id")
	private int list_id;

	public Items()
	{
		
	}
	
	public Items(int cid, String iname, String sname, int qty, float eprs, float sprs, int ibkt, int lid)
	{
		this.container_id = cid;
		this.item_name = iname;
		this.store_name = sname;
		this.qty = qty;
		this.eprise = eprs;
		this.sprise = sprs;
		this.inbucket = ibkt;
		this.list_id = lid;
	}

	public void setContainer_id(int container_id) {
		this.container_id = container_id;
	}	
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public void setEprise(float eprise)
	{
		this.eprise = eprise;
	}
	public void setInbucket(int inbucket)
	{
		this.inbucket = inbucket;
	}
	public void setSprise(float sprise)
	{
		this.sprise = sprise;
	}
	
	public void setList_id(int lid)
	{
		this.list_id = lid;
	}

	
	public int getContainer_id() {
		return this.container_id;
	}
	public String getItem_name() {
		return this.item_name;
	}
	public String getStore_name() {
		return this.store_name;
	}
	public int getQty() {
		return this.qty;
	}
	public float getEprise()
	{
		return this.eprise;
	}
	public int getInbucket()
	{
		return this.inbucket;
	}
	public float getSprise()
	{
		return this.sprise;
	}
	public int getList_id()
	{
		return this.list_id;
	}
	

}
