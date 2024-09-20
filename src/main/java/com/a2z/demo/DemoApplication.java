package com.a2z.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		String path=System.getenv("PATH");
		String home = System.getenv("HOME");
		String user=System.getenv("USER");
		String pwd=System.getenv("PWD");


		// Print the value
		System.out.println("Path: " + path);//Directories
		System.out.println("Home: " + home);//Current directory
		System.out.println("User: " + user);//name of the current user
		System.out.println("Pwd: " + pwd);//present working directory

	}

	@Component
	@ConfigurationProperties(prefix = "spring.application")
	class App
	{
//		@Value("${spring.application.name}")
//		private String name;
//
//		public void printAppConfig()
//		{
//			System.out.println("App name : "+name);
//		}

//		@Autowired
//		private Environment en;
//
//		public void printAppConfig()
//		{
//			System.out.println("App name : "+en.getProperty("spring.application.name"));
//		}
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	@Component
	class Start implements CommandLineRunner
	{
		private final App app;

        Start(App app) {
            this.app = app;
        }

        @Override
		public void run(String... args) throws Exception {
			//System.out.println("App name : "+app.getName());
		}
	}


}
