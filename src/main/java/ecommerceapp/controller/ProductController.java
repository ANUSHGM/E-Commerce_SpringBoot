package ecommerceapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import ecommerceapp.entity.ProductEntity;
import ecommerceapp.service.ProductService;


@RestController
public class ProductController {
	
	@Autowired
	ProductService service;

	@PostMapping("/enterProduct")
	public ResponseEntity<String> enterProduct (@RequestBody ProductEntity pdu){


		
		return service.AddProduct(pdu);
	}
	
	@GetMapping("/Products")
	public List<ProductEntity> GetProducts(){
		

		return service.GetProduct();
	}
}
