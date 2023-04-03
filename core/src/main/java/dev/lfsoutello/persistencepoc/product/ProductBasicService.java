package dev.lfsoutello.persistencepoc.product;

import dev.lfsoutello.persistencepoc.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductBasicService {

    private final ProductRepository productRepository;

    public ProductDTO create(ProductForm productForm) {
        Product product = Product.builder()
            .name(productForm.getName())
            .description(productForm.getDescription())
            .price(productForm.getPrice())
            .stock(productForm.getStock())
            .build();
        return ProductDTO.from(productRepository.save(product));
    }

    public ProductDTO read(Long id) {
        Product product = productRepository.findByIdAndDeletedFalse(id)
            .orElseThrow(ProductNotFoundException::new);
        return ProductDTO.from(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
