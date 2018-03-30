package com.iflow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iflow.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	@Query("SELECT new Users(u.user_id, u.username) FROM Users u WHERE u.username= :username AND u.password= :password")
	Users findUserByAuth(@Param("username") String username, @Param("password") String password);
}
