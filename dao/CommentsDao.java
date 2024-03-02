package com.jsp.Agro.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Agro.entity.Comments;
import com.jsp.Agro.repo.CommentsRepo;

@Repository
public class CommentsDao {
	@Autowired
	CommentsRepo repo;

	// ***********************Saving*******************************
	public Comments saveComments(Comments comment) {
		return repo.save(comment);
	}

	// *********************Fetching bYid*******************************
	public Comments fetchCommentById(int id) {
		Optional<Comments> db = repo.findById(id);
		if (db.isEmpty()) {
			return null;
		} else {
			return db.get();
		}
	}

	// ***********************Update********************************
	public Comments UpdateComments(Comments comment) {
		return repo.save(comment);
	}

	// **********************Deleting by id***************************
	public Comments daleteByCommentId(int id) {
		Optional<Comments> db = repo.findById(id);
		if (db.isEmpty()) {
			return null;
		} else {
			return db.get();
		}
	}

	// ********************FetchingAll************************
	public List<Comments> fetchAll() {
		return repo.findAll();
	}

}
