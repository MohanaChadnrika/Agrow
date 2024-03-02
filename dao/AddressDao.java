package com.jsp.Agro.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Agro.entity.Address;
import com.jsp.Agro.repo.AddressRepo;

@Repository
public class AddressDao {
	@Autowired
	AddressRepo repo;

	public Address updateAddress(Address address) {
		return repo.save(address);
	}

}
