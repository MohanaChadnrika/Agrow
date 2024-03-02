package com.jsp.Agro.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Agro.entity.User;
import com.jsp.Agro.repo.UserRepo;

@Repository
public class UserDao {
	@Autowired
	UserRepo repo;

	// --- Registration---saveOperation
	public User registerUser(User user) {
		System.out.println("register");
		System.out.println(user.getEmail());
		return repo.save(user);
	}

	// --- Find by user Id
	public User fetchUserById(int id) {
		Optional<User> db = repo.findById(id);
		if (db.isPresent()) {
			return db.get();
		} else {
			return null;
		}
	}

	// -- Updating user data
	public User updateUser(User user) {
		return repo.save(user);
	}

	// --- delete by user id
	public User deleteByUserId(int id) {
		Optional<User> db = repo.findById(id);

		repo.deleteById(id);
		return db.get();

	}

	// --- Fetching by User EMail
	public User FetchEmail(String email) {
		User db = repo.fetchByEmail(email);
		if (db == null) {
			System.out.println("fetch by email...");
			return null;
		} else
			return db;
	}

	// ---- fetching all user's data
	public List<User> fetchAll() {
		return repo.findAll();
	}
}
