package com.chw.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chw.bean.Category;
import com.chw.bean.Product;
import com.chw.service.ProductService;

@Controller
public class ProductC {

	@Autowired
	private ProductService service;
	
	@RequestMapping("/queryProducts.do")
	public ModelAndView queryProducts() {
		
		List<Product> products = service.queryProducts();
	    ModelAndView mv = new ModelAndView();
		mv.addObject("products", products);
		mv.setViewName("product_list");
		return mv;
	}

	
	@RequestMapping("/getInsertForm.do")
	public ModelAndView getInsertForm() {
		List<Category> categorys = service.queryAllCategory();
		System.out.println("categorys是的="+categorys);
		//System.out.println(categorys);
		ModelAndView mv = new ModelAndView();
		mv.addObject("categorys",categorys);
		mv.setViewName("insert-from");
		return mv;
	}
	
	@RequestMapping("/insertProduct.do")
	public ModelAndView insertProduct(Product product) {

		int result = service.insertProduct(product);
		System.out.println("product"+product);
		ModelAndView mv = new ModelAndView();
		
		if (result > 0) {
			mv.setViewName("redirect:/queryProducts.do");
		} else {
			mv.setViewName("fail");
		}
		return mv;

	}

	@RequestMapping("/deleteProduct.do")
	public ModelAndView deleteProduct(String id) {

		System.out.println(id);
		
		int result = service.deleteProduct(id);

		ModelAndView mv = new ModelAndView();
		if (result > 0) {
			mv.setViewName("redirect:/queryProducts.do");
		} else {
			mv.setViewName("fail");
		}
		return mv;
	}

	@RequestMapping("/getUpdateFrom.do")
	public ModelAndView getUpdateFrom(String id) {
		
		System.out.println(id);
		
		Product product = service.queryProduct(id);
		//查询所有的分类的东西
		List<Category> allCategorys = service.queryAllCategory();		
		System.out.println("allCategorys="+allCategorys);
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("product", product);
		
		mv.addObject("allCategorys",allCategorys);
		mv.setViewName("update-from");
		return mv;
	}

	@RequestMapping("/updateProduct.do")
	public ModelAndView updateProduct(Product product) {

		System.out.println(product);
		
		 int result=0;
		 //service1.updateCategory(category);
		 result = service.updateProduct(product);
		 ModelAndView mv = new ModelAndView();

		if (result > 0) {
			mv.setViewName("redirect:/queryProducts.do");
		} else {
			mv.setViewName("fail");
		}
		return mv;
	}
}
