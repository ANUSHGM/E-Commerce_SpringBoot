package ecommerceapp.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ecommerceapp.EcommerceNewApplication;
import ecommerceapp.CustomizedException.ResourceNotFoundException;
import ecommerceapp.entity.CartEntity;
import ecommerceapp.repository.CartRepository;
import ecommerceapp.repository.ProductRepository;
import ecommerceapp.service.BillingService;

@Service
public class BillingServiceImpl implements BillingService{

	@Autowired
	CartRepository crepo;
	
	@Autowired
	ProductRepository repo;
	
	Logger logger = LoggerFactory.getLogger(EcommerceNewApplication.class);


	@Override
	public ResponseEntity<String> GenerateBill() {
		if (crepo.findAll().isEmpty()) {
			throw new ResourceNotFoundException("Cart is empty");
		}

		String finalbill;
		int count = 1 ; 
		double totalBillAmount = 0.0;
		List<CartEntity> bill = new ArrayList<>();
		
		bill = crepo.findAll();
		
		finalbill = "S.no"+" "+"ItemID" +" "+ "ItemName" +" "+"Category" +" "+"ItemCost";

		for (CartEntity cart  : bill ) {

			totalBillAmount = totalBillAmount + cart.getCartItemCost();
			logger.debug(count +" "+ cart.getCartItemId() +" "+cart.getCartItemName()+" "+ cart.getCategory() +" "+ cart.getCartItemCost() );
			count = count + 1;
		}
		
		return new ResponseEntity<String>("Total cost of cart items = "+ totalBillAmount, HttpStatus.OK);
	}}

//		Logger logger = LoggerFactory.getLogger(EcommerceNewApplication.class);
//
//		 
//
//		List<Integer> cost=new ArrayList<>();      	 
//
//		List<Product> li=new ArrayList<>();     
//
//		 
//
//		int sno=1;                                                                                            @GetMapping("/generatebill")
//
//		 
//
//		public ResponseEntity<String> generateBill() {
//
//		 
//
//		 
//
//		for(Product product:li ) {
//
//		 
//
//		logger.debug(sno+" "+product.getName()+": "+product.getCost());
//
//		 
//
//		cost.add(product.getCost());
//
//		 
//
//		sno++;
//
//		 
//
//		}
//
//		 
//
//		 
//
//		int sum=cost.stream().mapToInt(Integer::intValue).sum();
//
//		 
//
//		cost.clear();
//
//		 
//
//		li.clear();
//
//		 
//
//		logger.debug("total cost is : "+ sum);
//
//		 
//
//		return new ResponseEntity<>("total cost is : "+sum,HttpStatus.OK);
//
//		 
//
//		}
//	}
//
//}
