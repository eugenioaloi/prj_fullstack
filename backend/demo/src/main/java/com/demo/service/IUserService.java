package com.demo.service;

import java.util.List;

import com.demo.info.UserInfo;

public interface IUserService {
	
	//get all
	List<UserInfo> getAllUsers();
	
	//Exists entity by email
	boolean existEmail(String email);

}
