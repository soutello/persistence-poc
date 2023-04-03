package dev.lfsoutello.persistencepoc.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
public class ProductPayload implements ProductForm {
    private String name;

    private String description;

    private BigDecimal price;

    private Integer stock;
}
