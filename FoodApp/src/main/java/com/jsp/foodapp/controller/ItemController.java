package com.jsp.foodapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.dao.ProductDao;
import com.jsp.foodapp.entities.FoodOrders;
import com.jsp.foodapp.entities.Item;
import com.jsp.foodapp.entities.Product;

@Controller
public class ItemController {
 @Autowired
 ProductDao productdao;
 
 @RequestMapping("/additem")
 public ModelAndView addItem(HttpSession session,@RequestParam("id") int id) {
	 if(session.getAttribute("itemsList")==null)
		 session.setAttribute("itemsList", new ArrayList<Item>());
	 ModelAndView mav=new ModelAndView("itemform");
	 Product p=productdao.viewProduct(id);
	 Item i=new Item();
	 i.setName(p.getName());
	 i.setCost(p.getCost());
	 i.setType(p.getType());
	 mav.addObject("itemobj",i);
	 return mav;
	 
 }
 @RequestMapping("additemtofoodorder")
 public ModelAndView additem(@ModelAttribute("itemobj")Item item,HttpSession session) {
	 item.setCost(item.getCost() * item.getQuantity());
	 FoodOrders order=(FoodOrders) session.getAttribute("userfoodorder");
	 item.setFoodorder(order);
	 List<Item> items=(List<Item>)session.getAttribute("itemsList");
	 items.add(item);
	 ModelAndView mav=new ModelAndView("redirect:/viewallproducts");
			 return mav;
 }
}
