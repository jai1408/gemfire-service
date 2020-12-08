package com.jai.cache.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.Region;

@Getter
@Setter
@NoArgsConstructor
@Region("customer")
@AllArgsConstructor
public class Customer {
  @Id private String firstname;
  private String lastname;
  private int age;
}
