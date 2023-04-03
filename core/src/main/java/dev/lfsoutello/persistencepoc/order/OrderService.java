package dev.lfsoutello.persistencepoc.order;

import dev.lfsoutello.persistencepoc.order.orderitem.OrderItemForm;
import dev.lfsoutello.persistencepoc.order.orderitem.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final OrderItemRepository orderItemRepository;

    public OrderDTO create(List<OrderItemForm> items) {
        return null;
    }

}
