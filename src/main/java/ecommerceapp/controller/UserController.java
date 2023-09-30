package ecommerceapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ecommerceapp.entity.UserEntity;



@RestController
public class UserController {

	@Autowired
	ecommerceapp.service.UserService service;

	
	
	@PostMapping("/signup")
	public ResponseEntity<String> RegisterUser (@RequestBody UserEntity usu){
		

		
		return service.RegisterUser(usu);
	}
	
	@GetMapping("/showuser")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<ecommerceapp.entity.UserEntity> Getuser(){
		

		return service.Getuser();
	}
	
}
