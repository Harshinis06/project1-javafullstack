package com.jsp.foodapp.controller;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.dao.AdminDao;
import com.jsp.foodapp.entities.Admin;

@Controller
public class AdminController {
     @Autowired
	AdminDao admindao;
	
	@RequestMapping("/addadmin")
	public ModelAndView addAdmin() {
		ModelAndView mav=new ModelAndView("createadmin");
		Admin admin=new Admin();
		mav.addObject("admin",admin);
		return mav;                           
	}
	@RequestMapping("/saveadmin")
	public ModelAndView saveAdmin(@ModelAttribute("admin") Admin admin) {
		ModelAndView mav=new ModelAndView("loginadmin");
		admindao.saveAdmin(admin);
	    return mav;
	}
	@RequestMapping("/validateadmin")
	public ModelAndView loginadmin(ServletRequest req) {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		Admin admin=admindao.login(email, password);
		if(admin==null) {
			ModelAndView mav=new ModelAndView("loginadmin");
			mav.addObject("message","Invalidcredentials");
			return mav;
		}
		else {
			ModelAndView mav=new ModelAndView("adminoption");
			mav.addObject("message","login successfull");
			return mav;
		}	
	}
}
