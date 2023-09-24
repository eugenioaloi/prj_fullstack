package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.info.UserInfo;
import com.demo.model.User;
import com.demo.repository.UserRepository;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserRepository repo;

	@Override
	public List<UserInfo> getAllUsers() {
		List<User> lstUser = new ArrayList<>();
		repo.findAll().forEach(us->lstUser.add(us));
		
		List<UserInfo> lstUserInfo = new ArrayList<>();
		for (int i = 0; i < lstUser.size(); i++) {
			UserInfo info = new UserInfo();
			BeanUtils.copyProperties(lstUser.get(i), info);
			lstUserInfo.add(info);
		}
		
		return lstUserInfo;
	}

	@Override
	public boolean existEmail(String email) {
		return repo.existsByEmail(email);
	}

	@Override
	public boolean existPassw(String password) {
		return repo.existsByPassword(password) ;
	}

	@Override
	public UserInfo getUser(String email, String password) {
		if(existEmail(email)) {
			User user = repo.findByEmail(email);
			boolean flag = user.getPassword().contains(password);
			if(flag) {
				UserInfo userInfo = new UserInfo();
				BeanUtils.copyProperties(user, userInfo);
				return userInfo;				
			}			
		}
		System.out.print("non esiste mail o psw");
		return null;
	}

	@Override
	public boolean registerUser(User user) {
		boolean flag = existEmail(user.getEmail());
		if(!flag) {
			repo.save(user);
			return true;
		}
		return false;
	}

}
