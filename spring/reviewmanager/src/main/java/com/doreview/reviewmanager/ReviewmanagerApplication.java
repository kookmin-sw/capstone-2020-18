package com.doreview.reviewmanager;

import com.doreview.reviewmanager.core.plans.domain.PlanRepo;
import com.doreview.reviewmanager.core.plans.domain.PlanRepository;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class ReviewmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewmanagerApplication.class, args);
	}

	@Bean
	public Mapper mapper() {
		return DozerBeanMapperBuilder.buildDefault();
	}


	@Bean
	public PlanRepository planRepository(){

		return new PlanRepo(new Dao());
	}
}
