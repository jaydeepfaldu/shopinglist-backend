package com.iflow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.iflow.model.Items;

public interface ItemsRepository extends JpaRepository<Items, Long> {


	
	@Query("SELECT new Items(i.container_id, i.item_name, i.store_name, i.qty, i.eprise,	i.sprise, i.inbucket, i.list_id) FROM Items i where i.list_id= :id")
	List<Items> findByListId(@Param("id") Integer id);
	
	@Query("SELECT new Items(i.container_id, i.item_name, i.store_name, i.qty, i.eprise,	i.sprise, i.inbucket, i.list_id) FROM Items i where i.list_id= :id AND i.inbucket = 1")
	List<Items> getItemInBucket(@Param("id") Integer id);
	
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Items i SET i.inbucket = :upd where i.container_id= :id")
	void updateInBucket(@Param("id") Integer id, @Param("upd") Integer upd);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Items i SET i.sprise = :upd where i.container_id= :id")
	void updateSprise(@Param("id") Integer id, @Param("upd") float upd);
	
}