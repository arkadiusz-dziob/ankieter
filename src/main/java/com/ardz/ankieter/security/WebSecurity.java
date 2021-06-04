package com.ardz.ankieter.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Md4PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
    @Autowired
    private CustomAuthenticationProvider authenticationProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/", "/login", "/registration").permitAll()
				.antMatchers("/odpowiedzi", "/pytania", "/registration").hasRole("ADMIN")
				.antMatchers("/quiz").hasRole("USER")
				.anyRequest().authenticated()
				.and()
			//.exceptionHandling().accessDeniedPage("/error")
			//.and()
			.formLogin().defaultSuccessUrl("/ankiety", true)
				.loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
				.permitAll()
				.and()
			.logout()
				.permitAll()
			.and()
		    .addFilterBefore(authenticationFilter(), UsernamePasswordAuthenticationFilter.class);

	}

	@Bean
	public PasswordEncoder encoder() {
	    return new Md5PasswordEncoder();
	}
	
	
	
	@Bean
	public UsernamePasswordAuthenticationFilter authenticationFilter() {
	    AuthenticationFilter authFilter = new AuthenticationFilter();
	    List<AuthenticationProvider> authenticationProviderList = new ArrayList<AuthenticationProvider>();
	    authenticationProviderList.add(authenticationProvider);
	    AuthenticationManager authenticationManager = new ProviderManager(authenticationProviderList);
	    authFilter.setAuthenticationManager(authenticationManager);
	    authFilter.setUsernameParameter("username");
	    authFilter.setPasswordParameter("password");
	    return authFilter;
	}
}
