package com.product.service.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class myConfigs {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
}
