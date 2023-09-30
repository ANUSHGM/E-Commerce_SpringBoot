package ecommerceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ecommerceapp.service.BillingService;

@RestController
public class BillingController {

	@Autowired
	BillingService service;
	
	@GetMapping("/buyNow")
	public ResponseEntity<String> GenerateBill(){
		

		return service.GenerateBill();

	}

}
