package com.iflow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iflow.dao.IItemDao;
import com.iflow.model.Items;

@Service
public class ItemService implements IItemService {

	
	@Autowired
	private IItemDao itemDAO;
	
	@Override
	public List<Items> getAllItems() {
		 List<Items> obj = itemDAO.getAllItems();
		return obj;
	}

	@Override
	public Items getItemById(int itemId) {
		Items obj = itemDAO.getItemById(itemId);
		return obj;
	}

	@Override
	public boolean addItem(Items item) {
		if (itemDAO.itemExists(item.getName(), item.getStore())) {
	    	   return false;
	       } else {
	    	   itemDAO.addItem(item);
	    	   return true;
	       }
	}

	@Override
	public void updateItem(Items item) {
		itemDAO.updateItem(item);
	}

	@Override
	public void deleteItem(int itemId) {
		itemDAO.deleteItem(itemId);
	}

	@Override
	public List<Items> getItemByBucket() {
		List<Items> obj = itemDAO.getItemByBucket();
		return obj;
	}

	@Override
	public void updateInbucket(int id, int inbucket) {
		itemDAO.updateInbucket(id, inbucket);
	}

	@Override
	public void updateSprice(int id, float sprice) {
		itemDAO.updateSprice(id, sprice);
		
	}
}
