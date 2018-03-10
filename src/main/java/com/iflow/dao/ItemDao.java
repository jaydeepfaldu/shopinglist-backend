package com.iflow.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iflow.model.Items;

@Transactional
@Repository
public class ItemDao implements IItemDao {

	
	@PersistenceContext	
	private EntityManager entityManager;
	
	
	@Override
	public List<Items> getAllItems() {
		String hql = "FROM items";
		return (List<Items>) entityManager.createQuery(hql).getResultList();
	}
	
	@Override
	public List<Items> getItemByBucket() {
		String hql = "FROM items  WHERE inbucket = 1";
		return (List<Items>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Items getItemById(int itemId) {
		return entityManager.find(Items.class, itemId);
	}

	@Override
	public void addItem(Items item) {
		entityManager.persist(item);
	}

	@Override
	public void updateItem(Items item) {
		Items itemm = getItemById(item.getId());
		itemm.setName(item.getName());
		itemm.setStore(item.getStore());
		itemm.setQty(item.getQty());
		itemm.setEprice(item.getEprice());
		entityManager.flush();
	}

	@Override
	public void deleteItem(int itemId) {
		entityManager.remove(getItemById(itemId));
	}

	@Override
	public boolean itemExists(String name, String store) {
		String hql = "FROM items as atcl WHERE atcl.name = ? and atcl.store = ?";
		int count = entityManager.createQuery(hql).setParameter(1, name)
		              .setParameter(2, store).getResultList().size();
		return count > 0 ? true : false;
	}

	@Override
	public void updateInbucket(int id, int inbucket) {
		Items itemm = getItemById(id);
		itemm.setInbucket(inbucket);
		entityManager.flush();
	}

	@Override
	public void updateSprice(int id, float sprice) {
		Items itemm = getItemById(id);
		itemm.setSprice(sprice);
		entityManager.flush();
	}

	

}
