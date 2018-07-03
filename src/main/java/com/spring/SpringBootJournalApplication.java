package com.spring;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.spring.domain.Journal;
import com.spring.repository.JournalRepository;

@SpringBootApplication(exclude = { AopAutoConfiguration.class })
public class SpringBootJournalApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(SpringBootJournalApplication.class, args);
	}

	@Autowired
	private JournalRepository repo;

	@Bean
	InitializingBean saveData()
	{
		return () ->
		{
			repo.save(new Journal("Get to know Spring Boot",
			                      "Today I will learn Spring Boot",
			                      "01/01/2016"));
			repo.save(new Journal("Simple Spring Boot Project",
			                      "I will do my first Spring Boot Project",
			                      "01/02/2016"));
			repo.save(new Journal("Spring Boot Reading",
			                      "Read more about Spring Boot",
			                      "02/01/2016"));
			repo.save(new Journal("Spring Boot in the Cloud",
			                      "Spring Boot using Cloud Foundry",
			                      "03/01/2016"));
		};
	}

}
