package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
  CommandLineRunner commandLineRunner(StudentRepository repository){
      return args -> {
          Student muhammed = new Student(
                  "muhammed",
                  "muhammedowoyale@gmail.com",
                  LocalDate.of(2000,12,3)
          );
          Student mariam = new Student(
                  "mariam",
                  "mariam@yahoo.com",
                  LocalDate.of(2001,3,12)
          );
          repository.saveAll(
                  List.of(muhammed,mariam));
      };
  }
}
