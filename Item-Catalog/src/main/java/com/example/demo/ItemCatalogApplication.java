package com.example.demo;

import com.example.demo.documents.ItemDocument;
import com.example.demo.documents.utils.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@CrossOrigin
@EnableEurekaClient
@SpringBootApplication
public class ItemCatalogApplication {

	@Autowired
	ItemRepository itemRepository;



	public static void main(String[] args) {
		SpringApplication.run(ItemCatalogApplication.class, args);
	}

}
