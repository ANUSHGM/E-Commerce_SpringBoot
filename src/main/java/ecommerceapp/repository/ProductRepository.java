package ecommerceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerceapp.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

	boolean existsBypName(String getpName);
	
	ProductEntity findById(int id);


}
