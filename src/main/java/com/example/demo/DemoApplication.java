package com.example.demo;

import DAO.People;
import config.ApplicationConfiguration;
import model.DataWork;
import model.DataWorkImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import view.ViewShow;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		ViewShow viewShow = context.getBean(ViewShow.class);
		viewShow.showListPeople();
	}
}
