package com.jikexueyuan.demo.springmvc.lesson3.dao;

import org.springframework.stereotype.Repository;

import com.jikexueyuan.demo.springmvc.lesson3.model.User;

@Repository
public class LoginDao {

	public User selectByUserName(String username) {
		if (!"admin".equals(username)) {
			return null;
		}
		User user = new User();
		user.setUserName("admin");
		user.setPassword("123");
		return user;
	}

}
