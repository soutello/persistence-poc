package dev.lfsoutello.persistencepoc.pesistence.order.orderitem;

import dev.lfsoutello.persistencepoc.pesistence.product.ProductDTO;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class OrderItemDTO {

    private Long id;

    private ProductDTO product;

    private int quantity;

    private BigDecimal price;

    public static OrderItemDTO from(OrderItem orderItem) {
        return OrderItemDTO.builder()
            .id(orderItem.getId())
            .product(ProductDTO.from(orderItem.getProduct()))
            .quantity(orderItem.getQuantity())
            .price(orderItem.getPrice())
            .build();
    }
}
