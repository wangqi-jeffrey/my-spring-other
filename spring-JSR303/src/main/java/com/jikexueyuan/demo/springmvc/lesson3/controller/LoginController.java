package com.jikexueyuan.demo.springmvc.lesson3.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jikexueyuan.demo.springmvc.lesson3.model.User;
import com.jikexueyuan.demo.springmvc.lesson3.service.LoginService;

/**
 * 这个例子讲解了如何定义MVC三层注解，使用@Resource进行注入，以及使用@RequestMapping、@RequestParam 、@SessionAttributes
 */

@Controller
public class LoginController {

	@Resource
	LoginService service;
	
	@Resource
	HttpServletRequest request;
	
	@RequestMapping("/register")
	public String toLoginPage(User user){
		return "/WEB-INF/jsp/register.jsp";
	}
	
	@RequestMapping(value = "/doRegister", method = RequestMethod.POST)
	public String doLogin(@Valid User user, BindingResult result, ModelMap map){
		
		// 如果入参有问题，返回注册页面
		if (result.hasErrors()) {
			List<FieldError> errorList = result.getFieldErrors();
            for(FieldError error : errorList){
                System.out.println(error.getField() + "*" + error.getDefaultMessage());
                map.put("ERR_" + error.getField(), error.getDefaultMessage());
            }
			return "/WEB-INF/jsp/register.jsp";
		}
		
		// 这里省略注册代码
		
		return "/WEB-INF/jsp/registersuccess.jsp";
	}
	
}
