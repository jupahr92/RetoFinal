/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jphr.demo.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
/**
 *
 * @author JUAN
 */


/**public class SecurityAdapter extends WebSecurityConfigurerAdapter{
    @Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests(
				a -> a.antMatchers("/", "/css/**", "/js/**", "/api/**", "/user", "/error", "/webjars/**").permitAll().anyRequest().authenticated())
				.exceptionHandling(e -> e.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
				.oauth2Login().defaultSuccessUrl("/menu.html",true);
                
                http.cors().and().csrf().disable();
	}
    
}*/
