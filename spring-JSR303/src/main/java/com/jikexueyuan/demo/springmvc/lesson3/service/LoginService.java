package com.jikexueyuan.demo.springmvc.lesson3.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jikexueyuan.demo.springmvc.lesson3.dao.LoginDao;
import com.jikexueyuan.demo.springmvc.lesson3.model.User;

@Service
public class LoginService {

	@Resource
	LoginDao dao ;

	public User doLogin(String username, String password) throws Exception {
		
		if (username == null || "".equals(username)) {
			throw new Exception("用户名不能为空");
		}
		
		if (password == null || "".equals(password)) {
			throw new Exception("密码不能为空");
		}
		
		User user = dao.selectByUserName(username);
		if (user == null) {
			throw new Exception("账号不存在");
		}
		
		if (!user.getPassword().equals(password)) {
			throw new Exception("密码不正确");
		}
		
		return user;
	}
	
}
