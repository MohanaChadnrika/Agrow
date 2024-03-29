package com.jsp.Agro.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.jsp.Agro.dao.UserDao;
import com.jsp.Agro.dao.exception.EmailAlreadyRegistered;
import com.jsp.Agro.dao.exception.EmailDoesNotExist;
import com.jsp.Agro.dao.exception.PasswordIncorrect;
import com.jsp.Agro.dao.utils.ResponseStructure;
import com.jsp.Agro.entity.User;

@Service
public class UserService {
	@Autowired
	UserDao dao;

	@Autowired
	JavaMailSender mailSender;

	public ResponseEntity<ResponseStructure<User>> registerUser(User user) {
		User db = dao.FetchEmail(user.getEmail());
		if (db == null) {
			System.out.println(db + "service");
			System.out.println(user.getEmail());

			User data = dao.registerUser(user);
			SimpleMailMessage smp = new SimpleMailMessage();

			smp.setFrom("m.c.peruru@gmail.com");
			smp.setTo(data.getEmail());
			smp.setSubject("Registration for Agrow");
			smp.setText("Thank you " + user.getFirstName() + " " + user.getLastName()
					+ " for registering to agrow application!!");
			mailSender.send(smp);
			ResponseStructure<User> rs = new ResponseStructure<User>();
			rs.setMessage("Registration successfull!!!");
			rs.setData(db);
			rs.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<User>>(rs, HttpStatus.CREATED);
		} else {
			throw new EmailAlreadyRegistered(user.getEmail() + " is already registered");
		}
	}
//	==============================================================================

//	================================login=========================================
	public ResponseEntity<ResponseStructure<User>> loginUser(String email, String password) {
		User data = dao.FetchEmail(email);
		if (data == null) {
			throw new EmailDoesNotExist(email + " does not exist");
		} else {
			if (password.equals(data.getPassword())) {
				ResponseStructure<User> rs = new ResponseStructure<User>();
				rs.setMessage("Login successfull!!!");
				rs.setData(data);
				rs.setStatus(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<User>>(rs, HttpStatus.OK);
			} else {
				throw new PasswordIncorrect("Password is wrong");
			}
		}
	}
//		===========================================================================

//		==============================update=====================================
	public ResponseEntity<ResponseStructure<User>> updateUser(User user) {
		User data = dao.FetchEmail(user.getEmail());
		if (data == null) {
			throw new EmailDoesNotExist("You cant change your email");
		} else {
			if (user.getId() == 0) {
				user.setId(data.getId());
			}
			if (user.getFirstName() == null) {
				user.setFirstName(data.getFirstName());
			}
			if (user.getLastName() == null) {
				user.setLastName(data.getLastName());
			}
			if (user.getEmail() == null) {
				user.setEmail(data.getEmail());
			}
			if (user.getPassword() == null) {
				user.setPassword(data.getPassword());
			}
			if (user.getPhone() == 0) {
				user.setPhone(data.getPhone());
			}
			if (user.getAddress() == null) {
				user.setAddress(data.getAddress());
			}
			if (user.getAge() == 0) {
				user.setAge(data.getAge());
			}
			if (user.getType() == null) {
				user.setType(data.getType());
			}
			User db = dao.updateUser(user);
			ResponseStructure<User> rs = new ResponseStructure<User>();
			rs.setData(db);
			rs.setMessage("updated succesfully");
			rs.setStatus(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<User>>(rs, HttpStatus.ACCEPTED);

		}
	}

//		================================================================================

//		================================fetchAll=======================================

	public ResponseEntity<ResponseStructure<List<User>>> fetchAll() {
		ResponseStructure<List<User>> rs = new ResponseStructure<List<User>>();
		List<User> list = dao.fetchAll();
		rs.setData(list);
		rs.setStatus(HttpStatus.FOUND.value());
		rs.setMessage("Fetched");
		return new ResponseEntity<ResponseStructure<List<User>>>(rs, HttpStatus.NOT_FOUND);
	}
//		=================================================================================

//		===============================Delete===========================================
	public ResponseEntity<ResponseStructure<User>> deleteUSer(int id) {
		User user = dao.fetchUserById(id);
		if (user == null) {
			throw new EmailDoesNotExist("No user with id: " + id + " is present");
		} else {
			System.out.println("inside service " + id);
			dao.deleteByUserId(id);
		}
		ResponseStructure<User> rs = new ResponseStructure<User>();
		rs.setData(user);
		rs.setMessage("User with id " + id + " is deleted");
		rs.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<User>>(rs, HttpStatus.OK);

	}
//		=====================================================================

//		===============================Generate OTP================================
	public ResponseEntity<ResponseStructure<Integer>> generateOtp(String email) {
		User data = dao.FetchEmail(email);
		if (data == null) {
			throw new EmailDoesNotExist("email : " + email + " has not registered try to register");
		} else {
			int otp = 0;
			for (int i = 0; i < 6; i++) {
				otp = otp * 10 + ((int) (Math.random() * 10));
			}
			SimpleMailMessage smp = new SimpleMailMessage();
			smp.setFrom("m.c.peruru@gmail.com");
			smp.setTo(email);
			smp.setSubject("Otp verifivation");
			smp.setText("Your otp for resetting password is: " + otp);
			mailSender.send(smp);

			ResponseStructure<Integer> rs = new ResponseStructure<Integer>();
			rs.setData(otp);
			rs.setMessage("otp sent successfully");
			rs.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Integer>>(rs, HttpStatus.OK);
		}

	}

}
