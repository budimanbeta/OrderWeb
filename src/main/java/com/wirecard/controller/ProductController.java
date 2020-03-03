package com.wirecard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wirecard.model.Product;
import com.wirecard.services.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/productList")
	public String productList(Model m) {
				
		m.addAttribute("listProduct", productService.findAllProduct());		
		return "product-list";
//		int data = listProduct.get(1).getId();
//		return "test aja "+data;
	}
	
	@GetMapping("/formProduct")
	public String formProduct(Model m) {
		m.addAttribute("newProduct", new Product());
		return "add-new-product";
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("newProduct") Product product) {
		
			productService.save(product);
			return "redirect:/productList";
	}
}
