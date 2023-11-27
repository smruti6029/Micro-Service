package com.user.service;

import java.util.List;

import com.user.entity.User;

public interface UserService {
	
	
	public User save(User user);
	
	public List<User> getAlluser();
	
	public User getUserByid(Integer id);
	
	
	
	

}
