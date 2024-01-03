package dev.lfsoutello.persistencepoc.pesistence.product;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Product {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(nullable = false, length = 30)
   private String name;

   @Column(nullable = false)
   private String description;

   @Column(nullable = false)
   private BigDecimal price;

   @Column(nullable = false)
   private int stock;

   @Column(nullable = false)
   private boolean deleted = false;
}
