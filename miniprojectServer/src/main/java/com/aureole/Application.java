package com.aureole;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class Application {
	
   public static void main(String[] args) throws IOException {
	  
        SpringApplication.run(Application.class, args);
    }
   
}