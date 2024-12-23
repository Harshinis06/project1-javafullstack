package com.jsp.foodapp.controller;

import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.dao.ProductDao;
import com.jsp.foodapp.entities.Product;

@Controller
public class ProductController {
  
	@Autowired
	ProductDao productdao;
	@RequestMapping("/addproduct")
	public ModelAndView addproduct() {
		ModelAndView mav=new ModelAndView("createproduct");
		Product product=new Product();
		mav.addObject("Product",product);
		return mav;
	}
	@RequestMapping("/saveproduct")
	public ModelAndView saveprodcut(@ModelAttribute("Product") Product p) {
		productdao.saveProduct(p);
		ModelAndView mav=new ModelAndView("adminoption");
		return mav;
	}
	@RequestMapping("/viewAllProdut")
	public ModelAndView viewAllproducts() {
		List<Product> productslist=productdao.viewAllProduct();
		ModelAndView mav=new ModelAndView("allproducts");
		mav.addObject("products",productslist);
		return mav;
	}
	@RequestMapping("/editproduct")
	public ModelAndView editproduct(@RequestParam("id") int id) {
		Product p=productdao.viewProduct(id);
		ModelAndView mav=new ModelAndView("updateproduct");
		mav.addObject("productdata",p);
		return mav;
	}
	@RequestMapping("/updateproducts")
	public ModelAndView updateproduct(ServletRequest req) {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String type=req.getParameter("type");
		String cost=req.getParameter("cost");
		Product product =new Product();
		product.setId(Integer.parseInt(id));
		product.setName(name);
		product.setType(type);
		product.setCost(Double.parseDouble(cost));
		
		productdao.updateProduct(product);
		
		ModelAndView mav=new ModelAndView("redirect:/viewAllProdut");
		return mav;
	}
	@RequestMapping("/deleteproduct")
	public ModelAndView deleteproducts(@RequestParam("id") int id) {
		productdao.deleteProductById(id);
		ModelAndView mav=new ModelAndView("redirect:/viewAllProdut");
		return mav;
	}
	@RequestMapping("/viewallproducts")
	public ModelAndView fetchAllproduct() {
		List<Product> products=productdao.viewAllProduct();
		ModelAndView mav=new ModelAndView("viewproducts");
		mav.addObject("productslist",products);
		return mav;
	}
}
