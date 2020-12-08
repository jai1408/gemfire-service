package com.jai.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

@SpringBootApplication
@EnableCaching
@EnableGemfireRepositories
public class SpringCacheApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringCacheApplication.class, args);
  }
}
