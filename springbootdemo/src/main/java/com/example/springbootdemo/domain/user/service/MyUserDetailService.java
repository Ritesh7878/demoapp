package com.example.springbootdemo.domain.user.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springbootdemo.domain.user.auth.AuthUser;
import com.example.springbootdemo.domain.user.entity.User;
import com.example.springbootdemo.domain.user.repository.UserRepository;


@Service("myUserDetailService")
public class MyUserDetailService implements UserDetailsService {

	private UserRepository userRepository;
	
	
	MyUserDetailService(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		Optional<User> user = userRepository.findByUsername(username);
		if(user.isPresent()) {
			return new AuthUser(user.get());
		}
		throw new UsernameNotFoundException("User not found in system.");
	}
	
	public User registerUser(User user) {
		Objects.requireNonNull(user);
		String userEmail = user.getEmail();
		userRepository.findByEmail(userEmail);
		
		
		
		return null;
		
	}

}
