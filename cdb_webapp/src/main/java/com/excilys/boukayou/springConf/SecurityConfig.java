package com.excilys.boukayou.springConf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	/*@Autowired
	HikariDataSource dataSource;*/
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) 
      throws Exception {
		//Definition of each role
        auth.inMemoryAuthentication().withUser("user").password("password").roles("USER")
        .and().withUser("admin").password("password").roles("ADMIN", "USER");
       
      /*  auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(
    			"select username,password, enabled from users where username=?")
    		.authoritiesByUsernameQuery(
    			"select username, role from user_roles where username=?");*/
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/**").hasRole("USER").and().formLogin().loginPage("/Login").failureUrl("/403");
		
     
    }
 
}
