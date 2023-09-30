package ecommerceapp.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

import ecommerceapp.EcommerceNewApplication;
import ecommerceapp.CustomizedException.AlreadyExistsException;
import ecommerceapp.CustomizedException.ResourceNotFoundException;
import ecommerceapp.entity.UserEntity;
import ecommerceapp.repository.UserRepository;
import ecommerceapp.service.UserService;



@Service
public class UserServiceImpl implements UserService{

@Autowired
UserRepository reps;

Logger logger = LoggerFactory.getLogger(EcommerceNewApplication.class);

@Autowired
PasswordEncoder encoder;
		
@Override
public ResponseEntity<String> RegisterUser(UserEntity usu) {
	if(reps.existsByEmail(usu.getEmail())) {
		
		throw new AlreadyExistsException("This Email id : "+usu.getEmail()+"  is already taken ");
	}
	
	try {
		usu.setPassword(encoder.encode(usu.getPassword()));
		logger.debug("try block entered");
		reps.save(usu);
		return new ResponseEntity<String>("Data entered successfully", HttpStatus.OK);

	}
	catch (Exception e) {
		logger.debug("catch entered");
		logger.error(e.getMessage());
		return new ResponseEntity<String>("Data not entered perfectly", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

@Override
public String welcome() {
	return "Welcome, All can access this page ";
}

@Override
public String onlyAdmin() {
	return "Only Admins can access this page ";
}

@Override
public String onlyUser() {
	return "Only User can access this page ";
}

@Override
public List<UserEntity> Getuser() {
	List<UserEntity> lst = new ArrayList<UserEntity>();
	
	
	lst = reps.findAll();
	
	if(lst.isEmpty()) {
		throw new ResourceNotFoundException("There are no users found in the database");
	}
	return lst;
}




}
	

