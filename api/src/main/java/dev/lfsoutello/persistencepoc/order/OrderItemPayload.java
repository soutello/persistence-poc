package dev.lfsoutello.persistencepoc.order;

import dev.lfsoutello.persistencepoc.order.orderitem.OrderItemForm;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class OrderItemPayload implements OrderItemForm {
    private Long productId;
    private int quantity;
}
