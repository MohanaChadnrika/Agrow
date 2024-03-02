package com.jsp.Agro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.Agro.UserService.UserService;
import com.jsp.Agro.dao.ImageDao;
//import com.jsp.Agro.dao.ImageDao;
import com.jsp.Agro.dao.utils.ResponseStructure;
import com.jsp.Agro.entity.Image;
//import com.jsp.Agro.entity.Image;
import com.jsp.Agro.entity.User;

@RestController
public class UserController {
	@Autowired
	UserService service;
	@Autowired
	ImageDao dao;

	// ****************************************************************************
	@PostMapping("/image")
	public Image saveImage(@RequestBody Image image) {
		return dao.saveImage(image);
	}

//	---------------------------------register-------------------------------
	@PostMapping("/register")
	public ResponseEntity<ResponseStructure<User>> registerUser(@RequestBody User user) {
		return service.registerUser(user);

	}
//	=============================================================================

//	-------------------------------------sendOtp--------------------------------
	@GetMapping("/getOtp")
	public ResponseEntity<ResponseStructure<Integer>> sendOtp(@RequestParam String email) {
		return service.generateOtp(email);
	}
//	===============================================================================

//	=====================================Fetch all====================================
	@GetMapping("/fetchAllUsers")
	public ResponseEntity<ResponseStructure<List<User>>> fetchAllUsers() {
		return service.fetchAll();
	}
//	======================================================================================

//	=======================================login======================================
	@GetMapping("/login")
	public ResponseEntity<ResponseStructure<User>> loginUser(@RequestParam String email, String password) {
		return service.loginUser(email, password);
	}
//	================================================================================================

//	=============================update=====================================
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user) {
		return service.updateUser(user);
	}
//	============================================================================

//	==============================Delete by id ===========================================
	@DeleteMapping("/deleteById")
	public ResponseEntity<ResponseStructure<User>> deleteUserById(@RequestParam int id) {
		System.out.println(id);
		return service.deleteUSer(id);
	}
//	=====================================

}
