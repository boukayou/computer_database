package com.excilys.boukayou.springConf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	HikariDataSource dataSource;
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) 
      throws Exception {
		//Definition of each role
        auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
       
      /*  auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(
    			"select username,password, enabled from users where username=?")
    		.authoritiesByUsernameQuery(
    			"select username, role from user_roles where username=?");*/
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/Dashboard")
           .access("hasRole('USER')")
           
         .antMatchers("/admin/**")
            .hasRole("ADMIN")
           .and()
            .formLogin()
            	.loginPage("/dashboard").failureUrl("/403")
            	.permitAll();
       /* 
        http.authorizeRequests()
		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
		.and()
		  .formLogin().loginPage("/login").failureUrl("/login?error")
		  .usernameParameter("username").passwordParameter("password")
		.and()
		  .logout().logoutSuccessUrl("/login?logout")
		.and()
		  .exceptionHandling().accessDeniedPage("/403")
		.and()
		  .csrf();*/
    }
   
}
