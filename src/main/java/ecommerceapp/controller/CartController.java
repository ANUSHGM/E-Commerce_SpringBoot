package ecommerceapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ecommerceapp.entity.CartEntity;
import ecommerceapp.service.CartService;

@RestController
public class CartController {
	
	@Autowired
	CartService service;

	@GetMapping("/addToCart/{id}/{count}")
	public ResponseEntity<String> addToCart(@PathVariable int id, @PathVariable int count) {


		
		return service.addToCart(id,count);

	}
	
	
	@GetMapping("/Cart")
	public List<CartEntity> showCart(){
		

		
		return service.showCart();
	}

	
	@GetMapping("/removeFromCart/{id}")
	public ResponseEntity<String> deleteFromCart(@PathVariable int id) {
		


		return service.deleteFromCart(id);
	}

	@GetMapping("/totalCartAmounts")
	public ResponseEntity<String> CartSum(){
		

		
		return service.CartSum();

	}
	
	@GetMapping("/ReduceCountCart/{id}/{count}")
	public ResponseEntity<String> ReduceCountCart(@PathVariable int id ,@PathVariable int count){
		return service.ReduceCountCart(id, count);
		
	}

	
}
