package com.iflow.dao;

import java.util.List;
import com.iflow.model.Items;

public interface IItemDao {
	
	
	    List<Items> getAllItems();
	    List<Items> getItemByBucket();
	    Items getItemById(int itemId);
	    void addItem(Items item);
	    void updateItem(Items item);
	    void deleteItem(int itemId);
	    boolean itemExists(String name, String store);
	    void updateInbucket(int id, int inbucket);
	    void updateSprice(int id, float sprice);
	    
	    
	
}
