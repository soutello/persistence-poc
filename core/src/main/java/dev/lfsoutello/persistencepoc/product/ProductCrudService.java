package dev.lfsoutello.persistencepoc.product;

import dev.lfsoutello.persistencepoc.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCrudService {

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

    public ProductDTO updateAll(ProductForm productForm, Long id) {
        Product product = productRepository.findByIdAndDeletedFalse(id)
            .orElseThrow(ProductNotFoundException::new);
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        product.setPrice(productForm.getPrice());
        product.setStock(productForm.getStock());
        return ProductDTO.from(productRepository.save(product));
    }

    public ProductDTO updateNonNull(ProductForm productForm, Long id) {
        Product product = productRepository.findByIdAndDeletedFalse(id)
            .orElseThrow(ProductNotFoundException::new);
        if (productForm.getName() != null) {
            product.setName(productForm.getName());
        }
        if (productForm.getDescription() != null) {
            product.setDescription(productForm.getDescription());
        }
        if (productForm.getPrice() != null) {
            product.setPrice(productForm.getPrice());
        }
        if (productForm.getStock() != null) {
            product.setStock(productForm.getStock());
        }
        return ProductDTO.from(productRepository.save(product));
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
