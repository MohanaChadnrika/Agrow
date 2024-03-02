package com.jsp.Agro.entity;

import java.time.LocalDateTime;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Post {
	@Id
	int id;
	@OneToOne(cascade = CascadeType.ALL)
	Image i;
	int likes;
	@OneToMany(cascade = CascadeType.ALL)
	List<Comments> comment;
	LocalDateTime dateTime;
	String caption;
	String location;

}
