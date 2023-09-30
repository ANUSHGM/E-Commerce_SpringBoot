package ecommerceapp.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ecommerceapp.entity.UserEntity;
import ecommerceapp.repository.UserRepository;



public class UserEntityUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<UserEntity> userInfo = repo.findByName(username);
		return userInfo.map(UserEntityUserDetails::new)
				.orElseThrow(()-> new UsernameNotFoundException("user not found + "+username));
	}
	

}
