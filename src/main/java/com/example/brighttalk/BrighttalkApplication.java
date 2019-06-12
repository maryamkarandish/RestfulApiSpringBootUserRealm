package com.example.brighttalk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MappingJackson2XmlView;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BrighttalkApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrighttalkApplication.class, args);
	}
	@Bean
	public ViewResolver contentNegotiatingViewResolver() {
		ContentNegotiatingViewResolver resolver =
				new ContentNegotiatingViewResolver();

		List<View> views = new ArrayList<>();
		views.add(new MappingJackson2XmlView());
		views.add(new MappingJackson2JsonView());
		resolver.setDefaultViews(views);
		return resolver;
	}

}
