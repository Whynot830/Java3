package com.example.pw13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Value;
@SpringBootApplication
public class Pw13Application {
	@Value("${student.name}")
	private String name;

	@Value("${student.last_name}")
	private String last_name;

	@Value("${student.group}")
	private String group;
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Pw13Application.class, args);

		Environment env = context.getBean(Environment.class);
		System.out.println(env.getProperty("student.name"));
		System.out.println(env.getProperty("student.last_name"));
		System.out.println(env.getProperty("student.group"));

		Pw13Application app = context.getBean(Pw13Application.class);
		System.out.println(app.name);
		System.out.println(app.last_name);
		System.out.println(app.group);

	}

}
