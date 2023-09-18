package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.info.UserInfo;
import com.demo.service.IUserService;

@RestController
@RequestMapping(value = "handleUsers")
@CrossOrigin
public class UserController {
	
	@Autowired
	IUserService service;
	
	@GetMapping(value="users", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserInfo>> getAllUsers(){
		List<UserInfo> lstInfo = service.getAllUsers();
		return new ResponseEntity<>(lstInfo, HttpStatus.OK);
	}
	
	
	@GetMapping(value="existsEmail/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> existsEmail(@PathVariable("email") String email){
		boolean flag = service.existEmail(email);//false non esiste
		if(!flag) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);//404 non trovato
		}
		return new ResponseEntity<>(HttpStatus.OK);//200 tutto OK
	}
	
}
