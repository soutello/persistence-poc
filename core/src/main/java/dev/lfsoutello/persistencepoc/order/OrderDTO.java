package dev.lfsoutello.persistencepoc.order;

import dev.lfsoutello.persistencepoc.order.orderitem.OrderItemDTO;
import lombok.Builder;
import lombok.Getter;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
public class OrderDTO {

    @Getter
    private Long id;

    private Set<OrderItemDTO> items;

    public Set<OrderItemDTO> getItems() {
        return Collections.unmodifiableSet(items);
    }

    public static OrderDTO from(Order order) {
        return OrderDTO.builder()
            .id(order.getId())
            .items(order.getItems().stream().map(OrderItemDTO::from).collect(Collectors.toSet()))
            .build();
    }
}
