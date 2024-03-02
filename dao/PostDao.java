package com.jsp.Agro.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Agro.entity.Post;
import com.jsp.Agro.repo.PostRepo;

@Repository
public class PostDao {
	@Autowired
	PostRepo repo;

	// *********************Save*****************************
	public Post savePost(Post post) {
		return repo.save(post);
	}

	// ********************Update*******************************
	public Post updatePost(Post post) {
		return repo.save(post);
	}

	// ********************delete******************************
	public Post deleteByPostId(int id) {
		Optional<Post> db = repo.findById(id);
		if (db.isEmpty()) {
			return null;
		} else {
			return db.get();
		}
	}

	// ********************Fetch********************************
	public Post fetchingPostByID(int id) {
		Optional<Post> db = repo.findById(id);
		if (db.isPresent()) {
			return db.get();
		} else {
			return null;
		}
	}

	// **********************FetchingAll********************************
	public List<Post> fetchAll() {
		return repo.findAll();
	}
}
