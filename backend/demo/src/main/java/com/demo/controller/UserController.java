package com.demo.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.info.UserInfo;
import com.demo.model.User;
import com.demo.service.IUserService;

@RestController
@RequestMapping(value = "handleUser")
@CrossOrigin
public class UserController {
	
	@Autowired
	IUserService service;
	
	@GetMapping(value="users", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserInfo>> getAllUsers(){
		List<UserInfo> lstInfo = service.getAllUsers();
		return new ResponseEntity<>(lstInfo, HttpStatus.OK);
	}
	
	
	@GetMapping(value="user/{email}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserInfo> getUser(@PathVariable String email, @PathVariable String password){
		UserInfo userInfo = service.getUser(email, password);
		if(userInfo!=null) {
			return new ResponseEntity<>(userInfo, HttpStatus.OK);//200 tutto OK
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "user")
	ResponseEntity<Void> registUser(@RequestBody UserInfo info){
		User user = new User();
		BeanUtils.copyProperties(info, user);
		boolean flag = service.registerUser(user);
		if(flag) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
}
