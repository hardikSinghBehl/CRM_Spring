package com.hardik.customerrelationshipmanagement.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public UserDetailsService userDetailsService() {	
		var userDetails = new InMemoryUserDetailsManager();
		userDetails.createUser(User.withUsername("hardik")
								   .password("abc123").authorities("ADMIN").build());
		return userDetails;
	}
	
	@Bean 
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().mvcMatchers("/css/**","/js/**").permitAll().anyRequest().authenticated()
				.and().formLogin().
				loginPage("/login").loginProcessingUrl("/login")
				.defaultSuccessUrl("/", true).permitAll()
				.and().logout().permitAll();
	}
	
	

}
