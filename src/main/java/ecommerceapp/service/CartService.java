package ecommerceapp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import ecommerceapp.entity.CartEntity;


public interface CartService {

	public ResponseEntity<String> addToCart(int id,int count);
	public List<CartEntity> showCart();
	public ResponseEntity<String> deleteFromCart(int id);
	public ResponseEntity<String> CartSum();
	public ResponseEntity<String> AlreadyInCart(int id , int count);
	public ResponseEntity<String> ReduceCountCart(int id , int count);

}
