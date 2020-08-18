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
public class ItemCatalogApplication implements Runnable {

	@Autowired
	ItemRepository itemRepository;

//	@Bean
//	public FilterRegistrationBean filterRegistrationBean() {
//		final CorsConfiguration config = new CorsConfiguration();
//		config.setAllowCredentials(true);
//		config.addAllowedOrigin("http://localhost:8081");
//		config.addAllowedHeader("*");
//		config.addAllowedMethod("*");
//		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", config);
//		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
//		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
//		return bean;
//	}

	public static void main(String[] args) {
		SpringApplication.run(ItemCatalogApplication.class, args);
	}

	@Override
	public void run() {
		System.out.println("In run");
		ItemDocument itemDocument = new ItemDocument();
		itemDocument.setItemId(1);
		itemDocument.setItemName("One Plus");
		itemDocument.setItemDescription("mobile phones");
		itemDocument.setItemPrice(7000.00);
		itemRepository.save(itemDocument);
	}
}
