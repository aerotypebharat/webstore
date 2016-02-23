/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.webstore.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
 
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
    private CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setHeaderName("csrf_token");
        repository.setSessionAttributeName("_csrf");
        return repository;
    }
    
    
    
    
    
    
    
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        
        auth.
                inMemoryAuthentication()
                .withUser("admin").password("password").roles("ADMIN");
        
    }
     
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .addFilterAfter(new CsrfTokenGeneratorFilter(), CsrfFilter.class)
                .authorizeRequests()
                .antMatchers("/", "/home","/rest/cart/").permitAll()               
                
                
                
                .antMatchers("/products/add").access("hasRole('ADMIN')")
                .and()
                .formLogin().loginPage("/login")
                .usernameParameter("j_username").passwordParameter("j_password")
                .and().csrf()
                
                
                .and()
                .exceptionHandling().accessDeniedPage("/loginfailed");
    }
    
    
}
