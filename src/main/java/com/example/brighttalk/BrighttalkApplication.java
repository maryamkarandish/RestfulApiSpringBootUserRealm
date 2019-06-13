package com.example.brighttalk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BrighttalkApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrighttalkApplication.class, args);
	}
//	@Bean
//	public ViewResolver contentNegotiatingViewResolver() {
//		ContentNegotiatingViewResolver resolver =
//				new ContentNegotiatingViewResolver();
//
//		List<View> views = new ArrayList<>();
//		views.add(new MappingJackson2XmlView());
//		views.add(new MappingJackson2JsonView());
//		resolver.setDefaultViews(views);
//		return resolver;
//	}

}
