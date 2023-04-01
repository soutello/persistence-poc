package dev.lfsoutello.simpleservicetemplate.example;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Setter
@Getter
@Entity
public class Example {
   @Id
   @GeneratedValue
   private Long id;
   private String text;
}
