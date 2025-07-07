package com.example.demo.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class StoredIntService {
  public int getStoredInt() {
    File file = new File("/tmp/stored-int.txt");
    Random ran = new Random();
    if (file.exists()) {
      try {
        String num = Files.readString(file.toPath());
        return Integer.parseInt(num);
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
    int randomNumber = ran.nextInt(1000);
    try {
      Files.writeString(file.toPath(), String.valueOf(randomNumber));
      return randomNumber;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
