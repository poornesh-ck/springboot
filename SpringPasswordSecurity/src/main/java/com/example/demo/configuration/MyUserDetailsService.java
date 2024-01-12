package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.example.demo.repo.Repo;
@Component
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private Repo r;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user= r.findByUserName(username);
		if(user==null)
			throw new UsernameNotFoundException("User 404");
			
		// TODO Auto-generated method stub
		return new MyUserDetails(user);
	}

}
