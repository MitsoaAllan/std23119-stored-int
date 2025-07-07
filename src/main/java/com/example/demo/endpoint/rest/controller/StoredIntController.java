package com.example.demo.endpoint.rest.controller;

import com.example.demo.service.StoredIntService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class StoredIntController {
  private final StoredIntService storedIntService;

  @GetMapping("/stored-int")
  public int storedInt() {
    return storedIntService.getStoredInt();
  }
}
