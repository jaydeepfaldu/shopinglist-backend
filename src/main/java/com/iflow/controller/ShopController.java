package com.iflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.iflow.model.Items;
import com.iflow.service.ItemService;


@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RestController
@RequestMapping("user")
public class ShopController {
	
	@Autowired
	private ItemService itemservice;
	
	
	@GetMapping("item/{id}")
	public ResponseEntity<Items> getItemById(@PathVariable("id") Integer id) {
		Items item = itemservice.getItemById(id);
		return new ResponseEntity<Items>(item, HttpStatus.OK);
	}
	
	
	@GetMapping("items")
	public ResponseEntity<List<Items>> getAllItems() {
		List<Items> list = itemservice.getAllItems();
		return new ResponseEntity<List<Items>>(list, HttpStatus.OK);
	}
	
	@PostMapping("item")
	public ResponseEntity<List<Items>> addItem(@RequestBody Items item, UriComponentsBuilder builder) {
        boolean flag = itemservice.addItem(item);
        List<Items> list = itemservice.getAllItems();
		
        if (flag == false) {
        	return new ResponseEntity<List<Items>>(list, HttpStatus.CONFLICT);
        	//return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
       // HttpHeaders headers = new HttpHeaders();
      //  headers.setLocation(builder.path("/item/{id}").buildAndExpand(item.getId()).toUri());
        return new ResponseEntity<List<Items>>(list, HttpStatus.CREATED);
       // return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	
	@PutMapping("item")
	public ResponseEntity<Items> updateItem(@RequestBody Items item) {
		itemservice.updateItem(item);
		return new ResponseEntity<Items>(item, HttpStatus.OK);
	}
	@DeleteMapping("item/{id}")
	public ResponseEntity<Void> deleteItem(@PathVariable("id") Integer id) {
		itemservice.deleteItem(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
	
	@GetMapping("itemsbybucket")
	public ResponseEntity<List<Items>> getAllItemsInBucket() {
		List<Items> list = itemservice.getItemByBucket();
		return new ResponseEntity<List<Items>>(list, HttpStatus.OK);
	}	
	
	@PutMapping("itembucket/{id}")
	public ResponseEntity<List<Items>> updateInbucket(@PathVariable("id") Integer id, @RequestBody Items item) {
		itemservice.updateInbucket(id, item.getInbucket());
		List<Items> list = itemservice.getAllItems();
		//return new ResponseEntity<List<Items>>(list, HttpStatus.OK);
		return new ResponseEntity<List<Items>>(list,HttpStatus.OK);
	}
	
	@PutMapping("itemsprice/{id}")
	public ResponseEntity<List<Items>> updateSprice(@PathVariable("id") Integer id, @RequestBody Items item) {
		itemservice.updateSprice(id, item.getSprice());
		List<Items> list = itemservice.getItemByBucket();
		return new ResponseEntity<List<Items>>(list,HttpStatus.OK);
	}
	
}
