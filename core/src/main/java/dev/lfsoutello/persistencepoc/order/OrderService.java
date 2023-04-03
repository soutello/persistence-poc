package dev.lfsoutello.persistencepoc.order;

import dev.lfsoutello.persistencepoc.exception.ProductNotFoundException;
import dev.lfsoutello.persistencepoc.order.orderitem.OrderItem;
import dev.lfsoutello.persistencepoc.order.orderitem.OrderItemForm;
import dev.lfsoutello.persistencepoc.order.orderitem.OrderItemRepository;
import dev.lfsoutello.persistencepoc.product.Product;
import dev.lfsoutello.persistencepoc.product.ProductRepository;
import dev.lfsoutello.persistencepoc.product.ProductStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final OrderItemRepository orderItemRepository;

    private final ProductRepository productRepository;

    private final ProductStockService productStockService;

    @Transactional
    public OrderDTO create(List<OrderItemForm> items) {
        Order order = new Order();

        items.forEach(item -> {
            if (item.getQuantity() <= 0) {
                throw new IllegalArgumentException("Quantity must be greater than 0");
            }

            Product product = productRepository.findByIdAndDeletedFalse(item.getProductId())
                .orElseThrow(ProductNotFoundException::new);

            productStockService.removeFromStock(product.getId(), item.getQuantity());

            OrderItem orderItem = OrderItem.builder()
                .product(product)
                .quantity(item.getQuantity())
                .build();

            orderItemRepository.save(orderItem);
            order.addItem(orderItem);
        });

        return OrderDTO.from(orderRepository.save(order));
    }

}
