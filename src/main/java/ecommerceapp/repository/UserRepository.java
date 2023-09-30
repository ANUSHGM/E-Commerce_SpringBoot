package ecommerceapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerceapp.entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Integer>{

	Optional<UserEntity> findByName(String username);

	boolean existsByEmail( String email);
}
