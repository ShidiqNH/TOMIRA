package com.store.convenienceStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
//@ComponentScan(basePackages = {"com.store.convenienceStore", "com.store.convenienceStore.controllers"})
public class ConvenienceStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConvenienceStoreApplication.class, args);
	}
	

}

