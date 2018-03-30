package com.iflow.repository;

import java.awt.ItemSelectable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iflow.model.ItemList;
import com.iflow.model.Users;


	@Repository
	public interface ItemListRepository extends JpaRepository<ItemList, Long> {

		@Query("SELECT new ItemList(tl.list_id, tl.list_title, tl.user_id) FROM ItemList tl WHERE tl.user_id= :user_id")
		List<ItemList> findByUsers(@Param("user_id") int user_id);
		
	}