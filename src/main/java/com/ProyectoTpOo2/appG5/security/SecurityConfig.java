package com.ProyectoTpOo2.appG5.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ProyectoTpOo2.appG5.service.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    String[] resources = new String[]{
            "/include/**","/css/**","/img/**"
    };
	
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
            .authorizeRequests()
	        .antMatchers(resources).permitAll()  
	        .antMatchers("/","/index").permitAll()
	        .antMatchers("/admin/**").access("hasRole('ADMIN')")
	        .antMatchers("/manager/**").access("hasRole('MANAGER') or hasRole('ADMIN')")
	        .antMatchers("/professor/**").access("hasRole('PROFESSOR') or hasRole('MANAGER') or hasRole('ADMIN')")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/menu")
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
            .logout()
                .permitAll()
                .logoutSuccessUrl("/login?logout");
    }
    BCryptPasswordEncoder bCryptPasswordEncoder;
   	
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        return bCryptPasswordEncoder;
    }
	
    
    @Autowired
    UserDetailsServiceImpl userDetailsService;
	
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());     
    }
}