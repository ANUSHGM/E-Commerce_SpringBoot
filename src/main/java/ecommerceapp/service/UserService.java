package ecommerceapp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import ecommerceapp.entity.UserEntity;



public interface UserService {

	public	String welcome();
	
	public	String onlyAdmin();
	
	public String onlyUser();
	
	public ResponseEntity<String> RegisterUser ( UserEntity usu);
	
	public List<UserEntity> Getuser();


}
