package com.greencross.test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JsonConfig {
	@Bean
	public ObjectMapper objectMapper() {
		return Jackson2ObjectMapperBuilder.json()
										  .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
										  .featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
										  .visibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
										  .modules(new JavaTimeModule())
										  .propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
										  .build();
	}
}
