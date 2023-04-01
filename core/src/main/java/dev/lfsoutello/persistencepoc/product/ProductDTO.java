package dev.lfsoutello.persistencepoc.product;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
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

    public static ProductDTO from(Product product) {
        return ProductDTO.builder()
            .id(product.getId())
            .name(product.getName())
            .description(product.getDescription())
            .price(product.getPrice())
            .build();
    }
}
