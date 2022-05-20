package com.ProyectoTpOo2.appG5.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.ProyectoTpOo2.appG5.entity.Role;
import com.ProyectoTpOo2.appG5.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
	
    @Override
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
    
     com.ProyectoTpOo2.appG5.entity.User appUser = 
    		 userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));
		
     List grantList = new ArrayList();
    for (Role role: appUser.getRoles()) {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
            grantList.add(grantedAuthority);
    }
		
    UserDetails user = (UserDetails) new User(appUser.getUsername(), appUser.getPassword(), grantList);
         return user;
    }
}
