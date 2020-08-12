package com.parkinglot.security;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub	
		
		return new User("mj", "$2a$10$NeT0wnlDDovgK.JhkhF1cubIvVt.6xjc9AxXpgAsGxh5BH.A1xZgO", new ArrayList<>());
	}

}
