package dev.lfsoutello.persistencepoc.pesistence.product;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString
@Builder
public class ProductDTO {
    private Long id;
    private String name;

    private String description;

    private BigDecimal price;

    private int stock;

    public static ProductDTO from(Product product) {
        return ProductDTO.builder()
            .id(product.getId())
            .name(product.getName())
            .description(product.getDescription())
            .price(product.getPrice())
            .stock(product.getStock())
            .build();
    }
}
