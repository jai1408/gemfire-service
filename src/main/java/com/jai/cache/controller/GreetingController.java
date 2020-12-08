package com.jai.cache.controller;

import com.jai.cache.model.Greeting;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/cache")
public class GreetingController {

  Map<String, Greeting> greetingMap = new HashMap<>();

  @PostConstruct
  public void initialized() {
    Greeting g1 = new Greeting("1", "Hello");
    Greeting g2 = new Greeting("2", "World");
    greetingMap.put(g1.getId(), g1);
    greetingMap.put(g2.getId(), g2);
  }

  @Cacheable("greetings")
  @GetMapping(value = "/greetings")
  public Collection<Greeting> getGreetings() throws InterruptedException {
    Thread.sleep(5000);
    return greetingMap.values();
  }

  @CacheEvict("greetings")
  @GetMapping(value = "/clear")
  public String clear() {
    return "cache Cleared successfully";
  }
}
