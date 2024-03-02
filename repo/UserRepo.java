package com.jsp.Agro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.Agro.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	@Query("select e from User e where email=?1")
	public User fetchByEmail(String email);
}
