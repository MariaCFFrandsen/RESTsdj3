package com.example.REST;

import java.net.URL;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @GetMapping("/greeting")
  public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    return new Greeting(counter.incrementAndGet(), String.format(template, name));
  }

  @PostMapping("/post")
  public void postGreeting(@RequestBody Greeting greeting){
    System.out.println(greeting.getId() + " " + greeting.getContent());
  }
}