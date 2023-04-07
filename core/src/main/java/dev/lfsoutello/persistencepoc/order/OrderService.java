package dev.lfsoutello.persistencepoc.order;

import dev.lfsoutello.persistencepoc.exception.InsufficientStockQuantityException;
import dev.lfsoutello.persistencepoc.exception.InvalidOrder;
import dev.lfsoutello.persistencepoc.exception.ProductNotFoundException;
import dev.lfsoutello.persistencepoc.order.orderitem.OrderItem;
import dev.lfsoutello.persistencepoc.order.orderitem.OrderItemForm;
import dev.lfsoutello.persistencepoc.product.ProductStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final ProductStockService productStockService;

    @Transactional
    public Order create(List<? extends OrderItemForm> items) {
        Order order = new Order();

        items.forEach(item -> {
            if (item.getQuantity() <= 0) {
                throw new InvalidOrder("Quantity must be greater than 0");
            }

            try {
                var product = productStockService.removeFromStock(item.getProductId(), item.getQuantity());
                OrderItem orderItem = OrderItem.builder()
                        .product(product)
                        .quantity(item.getQuantity())
                        .price(product.getPrice())
                        .build();
                order.addItem(orderItem);
            } catch (InsufficientStockQuantityException e) {
                throw new InvalidOrder("Insufficient stock quantity");
            } catch (ProductNotFoundException e) {
                throw new InvalidOrder("Product not found");
            }
        });

        return orderRepository.save(order);
    }

}
