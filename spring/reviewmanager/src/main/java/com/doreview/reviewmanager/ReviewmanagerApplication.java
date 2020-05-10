package com.doreview.reviewmanager;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReviewmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewmanagerApplication.class, args);
	}

	@Bean
	public Mapper mapper() {
		return DozerBeanMapperBuilder.buildDefault();
	}

}
