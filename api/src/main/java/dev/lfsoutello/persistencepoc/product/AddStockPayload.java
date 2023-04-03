package dev.lfsoutello.persistencepoc.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AddStockPayload {
    private Integer addQuantity;

    private Long productId;
}
