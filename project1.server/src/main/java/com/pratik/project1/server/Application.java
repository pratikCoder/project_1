package com.pratik.project1.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import com.pratik.project1.server.configuration.CustomAuthenticationProvider;
import com.pratik.project1.service.UserService;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = { "com.pratik" })
public class Application {

	@Autowired
	CustomAuthenticationProvider authProvider;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserService userservice) throws Exception {
		builder.authenticationProvider(authProvider);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
}
