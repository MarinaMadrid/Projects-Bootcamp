package com.example.demo.config;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaConfig {

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Bean
	public Session getSession() {
		
		SessionFactory factory = entityManagerFactory.unwrap(SessionFactory.class);
		return factory.openSession();
	}
}
