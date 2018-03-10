package com.iflow.service;

import java.util.List;



import com.iflow.model.Items;


public interface IItemService {
	
    List<Items> getAllItems();
    List<Items> getItemByBucket();
    Items getItemById(int itemId);	
    boolean addItem(Items item);	
    void updateItem(Items item);	
    void deleteItem(int itemId);
    void updateInbucket(int id, int inbucket);
    void updateSprice(int id, float sprice);
 
    
}
