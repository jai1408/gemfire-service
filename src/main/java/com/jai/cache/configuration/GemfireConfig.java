package com.jai.cache.configuration;

import com.gemstone.gemfire.cache.GemFireCache;
import com.jai.cache.model.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.LocalRegionFactoryBean;

import java.util.Properties;

@Configuration
public class GemfireConfig {
    @Bean
    Properties gemfireProperties() {
        Properties gemfireProperties = new Properties();
        gemfireProperties.setProperty("name", "EmbeddedGemfireApplication");
        gemfireProperties.setProperty("mcast-port", "0");
        return gemfireProperties;
    }
    
    @Bean
    CacheFactoryBean gemfireCache() {
        CacheFactoryBean gemfireCache = new CacheFactoryBean();
        gemfireCache.setProperties(gemfireProperties());
        return gemfireCache;
    }
    
    @Bean
    LocalRegionFactoryBean<String, Customer> customerRegion(final GemFireCache cache) {
        LocalRegionFactoryBean<String, Customer> customerRegion = new LocalRegionFactoryBean<>();
        customerRegion.setCache(cache);
        customerRegion.setName("customer");
        customerRegion.setPersistent(false);
        return customerRegion;
    }
}