package com.jsp.foodapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.dao.FoodOrdersDao;
import com.jsp.foodapp.dao.UserDao;
import com.jsp.foodapp.entities.FoodOrders;
import com.jsp.foodapp.entities.Item;
import com.jsp.foodapp.entities.User;

@Controller
public class FoodorderController {
  
	@Autowired
	FoodOrdersDao foodorderdao;
	@Autowired
      UserDao userdao;
	
	double totalbill=0;
	
	@RequestMapping("/createorder")
	public ModelAndView createfoodorder() {
		ModelAndView mav=new ModelAndView("createfoodorder");
		FoodOrders foodorder=new FoodOrders();
		mav.addObject("foodorders",foodorder);
		return mav;
	}
	@RequestMapping("/savefoodorder")
	public ModelAndView savefoodorder(@ModelAttribute("foodorders") FoodOrders foodorder,HttpSession session) {
		session.setAttribute("userfoodorder", foodorder);
		ModelAndView mav=new ModelAndView("redirect:/viewallproducts");
		return mav;
	}
	@RequestMapping("/submitfoodorder")
	public ModelAndView submitfoodorder(HttpSession session) {
		FoodOrders foodorders=(FoodOrders)session.getAttribute("userfoodorder");
		List<Item> items=(List<Item>) session.getAttribute("itemsList");
		foodorders.setItem(items);
	
		items.stream().forEach(i->{
				totalbill=totalbill+i.getCost();
	});
		foodorders.setTotalbill(totalbill);
		
		User u=(User)session.getAttribute("user");
		List<FoodOrders> orders=u.getfoodOrders();
		if(orders.size()>0) {
			orders.add(foodorders);
			foodorders.setUser(u);
			u.setFo(orders);
		}
		else {
			List<FoodOrders> orders1=new ArrayList<FoodOrders>();
			orders1.add(foodorders);
			foodorders.setUser(u);
			u.setFo(orders1);
		}
		foodorderdao.saveFoodOrders(foodorders);
		userdao.updateUser(u);
		
		ModelAndView mav=new ModelAndView("useroption");
		return mav;
}
}
