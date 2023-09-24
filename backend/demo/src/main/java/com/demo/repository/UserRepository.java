package com.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.model.User;

public interface UserRepository extends CrudRepository<User,Integer> {
	
	/*Custom query result - ERROR TO FIX	:
	 
		No converter found capable of converting from type [java.lang.String] to type 
		[@org.springframework.data.jpa.repository.Query com.demo.model.User]
	 
		@Query(value = "SELECT u.email,u.password FROM User u")
		List<User> getUserEmailPsw();
	*/
	
	User findByEmail(String email);
	
	boolean existsByEmail(String email);
	boolean existsByPassword(String password);
	

}
