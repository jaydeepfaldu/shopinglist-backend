package com.iflow;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.iflow.model.Users;
import com.iflow.repository.UserRepository;


@SpringBootApplication
public class MyApplication extends SpringBootServletInitializer {  
	
	
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MyApplication.class);
    }
	
	
	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
    }


	
}            