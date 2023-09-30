package ecommerceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerceapp.entity.CartEntity;

public interface CartRepository extends JpaRepository<CartEntity, Integer>{

	CartEntity findById(int id);

}
