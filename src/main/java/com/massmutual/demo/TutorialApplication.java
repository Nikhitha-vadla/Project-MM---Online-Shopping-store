package com.massmutual.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TutorialApplication {

	public static void main(String[] args) {
		
//		SpringApplication.run(TutorialApplication.class, args);
		ApplicationContext context= SpringApplication.run(TutorialApplication.class, args);
	
	}

}
 