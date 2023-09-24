package com.demo.service;

import java.util.List;

import com.demo.info.UserInfo;
import com.demo.model.User;

public interface IUserService {
	
	//get all
	List<UserInfo> getAllUsers();
	
	//get user
	UserInfo getUser(String email, String password);
	
	//Exists entity by email
	boolean existEmail(String email);
	
	//Exists entity by password
	boolean existPassw(String password);
	
	//Add User
	boolean registerUser(User user);
	

}
