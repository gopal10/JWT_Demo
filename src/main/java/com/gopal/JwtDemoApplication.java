package com.gopal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.gopal.Jfilter.JwtFilter;

@SpringBootApplication
public class JwtDemoApplication {
	
	@Bean
	public FilterRegistrationBean jwtFilter() {
		FilterRegistrationBean filter = new FilterRegistrationBean<>();
		filter.setFilter(new JwtFilter());
		filter.addUrlPatterns("/api/v1/gopal/*");
		
		return filter;
		
	}

	public static void main(String[] args) {
		SpringApplication.run(JwtDemoApplication.class, args);
	}

}
