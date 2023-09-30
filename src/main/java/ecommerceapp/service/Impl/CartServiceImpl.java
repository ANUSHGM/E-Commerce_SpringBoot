package ecommerceapp.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ecommerceapp.EcommerceNewApplication;
import ecommerceapp.CustomizedException.AlreadyExistsException;
import ecommerceapp.CustomizedException.ResourceNotFoundException;
import ecommerceapp.entity.CartEntity;
import ecommerceapp.entity.ProductEntity;
import ecommerceapp.repository.CartRepository;
import ecommerceapp.repository.ProductRepository;
import ecommerceapp.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	CartRepository crepo;
	
	@Autowired
	ProductRepository repo;
	
	Logger logger = LoggerFactory.getLogger(EcommerceNewApplication.class);

	String status = null ;

	public ResponseEntity<String> addToCart(int id , int count) {
		logger.info("addToCart method is called");

	
		
		if (!repo.existsById(id)) {
			logger.debug("working");
			throw new ResourceNotFoundException("Product with the given id :" + id + " is not found");
		}


		if (crepo.existsById(id)) {
			logger.warn("user already exist");
			status = "item already exists in cart so count increased";
			AlreadyInCart(id , count );
		}

		else {
			
			CartEntity cart = new CartEntity();
			ProductEntity opt = repo.findById(id);
			cart.setCartItemId(opt.getpId());
			cart.setCartItemName(opt.getpName());
			cart.setCartItemStatus(opt.getStatus());
			cart.setCartItemCost(opt.getCost());
			cart.setCategory(opt.getCategory());
			cart.setCount(count);
			crepo.save(cart);
			logger.info("product added to cart");
			status = "Item added to Cart successfully";
		}
		return new ResponseEntity<String>(status, HttpStatus.OK);

	}

	public List<CartEntity> showCart() {
		logger.info("showcart method is called");
		if (crepo.findAll().isEmpty()) {
			throw new ResourceNotFoundException("Cart is empty");
		}
		logger.info("showing cart");
		return crepo.findAll();
	}

	public ResponseEntity<String> deleteFromCart(int id) {
		logger.info("deletefrom cart is called");
		if (crepo.findAll().isEmpty()) {
			logger.info("cart is empty");
			throw new ResourceNotFoundException("Cart is empty");
		}

		if (!crepo.existsById(id)) {
			logger.info("item doesn't exist in cart");
			throw new ResourceNotFoundException("This item doesn't exist in cart");
		}
		crepo.deleteById(id);
		logger.info("deleting item from cart");
		return new ResponseEntity<String>("Item removed from Cart successfully", HttpStatus.OK);

	}

	public ResponseEntity<String> CartSum() {
		
		logger.info("cartSum is called");
		if (crepo.findAll().isEmpty()) {
			logger.warn("cart is empty");
			throw new ResourceNotFoundException("Cart is empty");
		}

		Double CartSum = 0.0;
		List<CartEntity> crt = new ArrayList<>();

		crt = crepo.findAll();

		for (CartEntity cart : crt) {
			CartSum = CartSum + cart.getCartItemCost()* cart.getCount();
		}
		logger.info("total cart amount is showing");
		return new ResponseEntity<String>("Total cost of cart items = " + CartSum, HttpStatus.OK);

	}

	
	public ResponseEntity<String> AlreadyInCart(int id , int count) {
		CartEntity carts = crepo.findById(id);
		carts.setCount(carts.getCount()+ count);
		crepo.save(carts);
		status = "Item ("+carts.getCartItemName()+") count updated in the cart as item is already added to cart , current count - "+carts.getCount();
		return new ResponseEntity<String>("Item ("+carts.getCartItemName()+") count updated in the cart as item is already added to cart , current count - "+carts.getCount(),HttpStatus.OK);
	}

	public ResponseEntity<String> ReduceCountCart(int id, int count) {
		
		if (crepo.findAll().isEmpty()) {
			logger.info("cart is empty");
			throw new ResourceNotFoundException("Cart is empty");
		}

		if (!crepo.existsById(id)) {
			logger.info("item doesn't exist in cart");
			throw new ResourceNotFoundException("This item doesn't exist in cart");
		}
		
		CartEntity crt = crepo.findById(id);
		crt.setCount(crt.getCount()- count);
		crepo.save(crt);
		status = "Item ("+crt.getCartItemName()+") count reduced in the cart , current count - "+crt.getCount();

		return new ResponseEntity<String>(status, HttpStatus.OK);
	}

}
