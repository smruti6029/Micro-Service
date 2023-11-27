package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.User;
import com.user.service.UserService;

@RestController
@RequestMapping("/user/")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/save")
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		User save = userService.save(user);

		return new ResponseEntity<User>(save, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getuserBYid(@PathVariable Integer id) {
		User userByid = userService.getUserByid(id);
		return new ResponseEntity<User>(userByid, HttpStatus.OK);

	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllUser()
	{
		List<User> alluser = userService.getAlluser();
		return new ResponseEntity<List<User>>(alluser, HttpStatus.OK);
	}

}
