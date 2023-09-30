package ecommerceapp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;


import ecommerceapp.entity.ProductEntity;

public interface ProductService {

	public ResponseEntity<String> AddProduct (ProductEntity pdu);
	public List<ProductEntity> GetProduct();
}