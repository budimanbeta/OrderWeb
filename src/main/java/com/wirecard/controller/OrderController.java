package com.wirecard.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.wirecard.dto.CartDto;
import com.wirecard.dto.OrderItemDto;
import com.wirecard.model.OrderItem;
import com.wirecard.model.Order;
import com.wirecard.model.Product;
import com.wirecard.services.OrdersService;
import com.wirecard.services.ProductService;

@SessionAttributes({"cart"})
@Controller
public class OrderController {

	@ModelAttribute("cart")
	public CartDto createCart() {
		return new CartDto();
	}
	
	@Autowired 
	ProductService productService;
	@Autowired
	OrdersService ordersService;
	
	@GetMapping("/order-view")
	public String orderList(Model model, 
			@ModelAttribute ("cart") CartDto cart) {
		
		model.addAttribute("cart", cart);
		return "order-view";
	}
	
	@GetMapping("/choose-product")
	public String viewProduct(Model model, @ModelAttribute("orderItemDto") OrderItemDto orderItemDto){
		model.addAttribute("products",productService.findAllProduct());
		return "choose-product2";
	}
	
	@PostMapping("/select-product")
	public ModelAndView selectProduct(@ModelAttribute("orderItemDto") OrderItemDto orderItemDto,  
			@ModelAttribute("cart") CartDto cart) {
		
		Product product = (Product) productService.getById(orderItemDto.getId());
		orderItemDto.setName(product.getName());
		orderItemDto.setPrice(product.getPrice());
		
		cart.addItemDto(orderItemDto);
		
		return new ModelAndView("redirect:/order-view");
	}
	
	@PostMapping("/order-submit")
	public String prosessOrders(@ModelAttribute("cart") CartDto cart,SessionStatus sessionStatus) {
	
		Order order = generateOrderFromCart(cart);
		ordersService.save(order);
		sessionStatus.setComplete();
		
		return "success-order";
	}

	private Order generateOrderFromCart(CartDto cart) {
		Order order = new Order();
		List<OrderItem> items = new ArrayList<OrderItem>();
		for(OrderItemDto itemDto : cart.getOrderItemsDto()) {
			OrderItem item = new OrderItem();
		
			Product product = new Product();
			product.setId(itemDto.getId());
			item.setProduct(product);
			item.setQuantity(itemDto.getQuantity());
			
			items.add(item);
		}
		order.setOrderDate(new Date());
		order.setItems(items);
		
		return order;
	}
	
	
}
