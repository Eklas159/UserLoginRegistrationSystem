package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.Repository.UserRepository;
import com.example.demo.model.User;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	
	UserRepository userRepository;
	public CustomUserDetailsService(UserRepository userRepository) {
	  this.userRepository=userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepository.findByEmail(username);
		if(user==null) 
			throw new UsernameNotFoundException("user name not found");
		return new CustomUserDetails(user) ;
	}

}
