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
import ecommerceapp.CustomizedException.AlreadyExistsException;
import ecommerceapp.CustomizedException.ResourceNotFoundException;
import ecommerceapp.entity.ProductEntity;
import ecommerceapp.repository.ProductRepository;
import ecommerceapp.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository repo;
	
	Logger logger = LoggerFactory.getLogger(EcommerceNewApplication.class);

	
	@Override
	public ResponseEntity<String> AddProduct(ProductEntity pdu) {
		if(repo.existsBypName(pdu.getpName())) {
			throw new AlreadyExistsException(pdu.getpName()+" already exists in product list");
		}
		try {
			repo.save(pdu);
			return new ResponseEntity<String>("Data entered successfully", HttpStatus.OK);

		}
		
		catch (Exception e) {
			logger.error("Data not entered perfectly");
			return new ResponseEntity<String>("Data not entered perfectly", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public List<ProductEntity> GetProduct() {
		List<ProductEntity> plist = new ArrayList<ProductEntity>();
		plist = repo.findAll();
		if(plist.isEmpty()) {
			throw new ResourceNotFoundException("There are no products found in the database");
		}
		return plist;
	}

}
