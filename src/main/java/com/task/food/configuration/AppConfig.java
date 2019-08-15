package com.task.food.configuration;

import com.fatsecret.platform.services.FatsecretService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Value("${fatsecretapi.key}")
  private String key;

  @Value("${fatsecretapi.secret}")
  private String secret;

  @Bean
  public FatsecretService fatsecretService() {
    return new FatsecretService(key, secret);
  }

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }
}
