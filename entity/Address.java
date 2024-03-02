package com.jsp.Agro.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Address {
	@Id
	int id;
	String houseName;
	String street;
	String landmark;
	String mandal;
	String district;
	String state;
	int pin;

}
