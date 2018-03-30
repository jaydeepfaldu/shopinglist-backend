package com.iflow.controller;

import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.iflow.model.ItemList;
import com.iflow.model.Items;
import com.iflow.repository.ItemsRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("item")
public class ItemContainerController {

	@Autowired
	private ItemsRepository itemsRepository;
	
	@GetMapping("items")
	public ResponseEntity<List<Items>> getAllItems() {
		List<Items> items = itemsRepository.findAll();
		return new ResponseEntity<List<Items>>(items, HttpStatus.OK);
	}
	
	@GetMapping("items/inbucket/{id}")
	public ResponseEntity<List<Items>> getItemInBucket(@PathVariable("id")  Integer id) {
		
		List<Items> item = itemsRepository.getItemInBucket(id);
		return new ResponseEntity<List<Items>>(item,HttpStatus.OK);
	}
	
	@GetMapping("items/{id}")
	public ResponseEntity<List<Items>> getAllItemListsByListId(@PathVariable("id") Integer id) {
		List<Items> items = itemsRepository.findByListId(id);
		return new ResponseEntity<List<Items>>(items, HttpStatus.OK);
	}
	
	@PostMapping("item")
	public ResponseEntity<List<Items>> addItem(@RequestBody Items items) {
		itemsRepository.saveAndFlush(items);
		List<Items> getitems = itemsRepository.findByListId(items.getList_id());
		return new ResponseEntity<List<Items>>(getitems, HttpStatus.OK);
	}
	
	@PutMapping("item/inbucket/{id}")
	public ResponseEntity<List<Items>> updateItemInBucket(@PathVariable("id")  Integer id, @RequestBody Items items) {
		itemsRepository.updateInBucket(id, items.getInbucket());
		List<Items> item = itemsRepository.findByListId(items.getList_id());
		return new ResponseEntity<List<Items>>(item,HttpStatus.OK);
	}
	
	
	@PutMapping("item/sprise/{id}")
	public ResponseEntity<List<Items>> updateItemSprise(@PathVariable("id")  Integer id, @RequestBody Items items) {
		itemsRepository.updateSprise(id, items.getSprise());
		List<Items> item = itemsRepository.getItemInBucket(items.getList_id());
		return new ResponseEntity<List<Items>>(item,HttpStatus.OK);
	}
	
	
	
}
