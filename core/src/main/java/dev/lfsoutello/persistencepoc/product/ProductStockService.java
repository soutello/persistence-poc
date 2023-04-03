package dev.lfsoutello.persistencepoc.product;

import dev.lfsoutello.persistencepoc.exception.InsufficientStockQuantityException;
import dev.lfsoutello.persistencepoc.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductStockService {

    private final ProductRepository productRepository;

    @Transactional
    public ProductDTO addToStock(long id, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }

        Product product = productRepository.findByIdAndDeletedFalse(id)
            .orElseThrow(ProductNotFoundException::new);

        product.setStock(product.getStock() + quantity);
        return ProductDTO.from(productRepository.save(product));
    }

    @Transactional
    public ProductDTO removeFromStock(long id, int quantity) {
        log.info("[{}] removeFromStock: id={}, quantity={}", this.getClass().getSimpleName(), id, quantity);
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }

        Product product = productRepository.findByIdAndDeletedFalse(id)
            .orElseThrow(ProductNotFoundException::new);

        if (product.getStock() < quantity) {
            throw new InsufficientStockQuantityException();
        }

        product.setStock(product.getStock() - quantity);
        return ProductDTO.from(productRepository.save(product));
    }
}
