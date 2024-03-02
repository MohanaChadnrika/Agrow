package com.jsp.Agro.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.Agro.entity.Comments;

public interface CommentsRepo extends JpaRepository<Comments, Integer>{

}
