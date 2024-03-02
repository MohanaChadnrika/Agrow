package com.jsp.Agro.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Comments {// owning class

	@Id
	int id;
	String msg;
	@OneToOne(cascade = CascadeType.ALL)
	User user;

}
