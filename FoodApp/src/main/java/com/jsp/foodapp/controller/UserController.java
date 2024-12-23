
package com.jsp.foodapp.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.dao.UserDao;
import com.jsp.foodapp.entities.User;

@Controller    
public class UserController {
	@Autowired
UserDao userdao;
	
	@RequestMapping("/createaccount")
	public ModelAndView creatusers() {
		ModelAndView mav=new ModelAndView("createuser");
		User user=new User();
		mav.addObject("users",user);
		return mav;
	}
	@RequestMapping("/createuser")
	public ModelAndView saveUser(@ModelAttribute("users") User users) {
		userdao.saveUser(users);
		ModelAndView mav=new ModelAndView("usermenu");
		return mav;
	}
	@RequestMapping("/validateuser")
	public ModelAndView loginvalidation(ServletRequest req,HttpSession session) {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		User u= userdao.login(email, password);
		if(u==null) {
			ModelAndView mav=new ModelAndView("loginuser");
			mav.addObject("a","invalidcrediatials");
			return mav;
		}
		else {
			ModelAndView mav=new ModelAndView("useroption");
			session.setAttribute("user", u);
			mav.addObject("b","loginsucessfully");
			return mav;
		}
			
	}
	
}
