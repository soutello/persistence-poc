package dev.lfsoutello.persistencepoc.product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody ProductPayload body) {
        log.info("[ExampleController] m=create, body={}", body);
        return ResponseEntity.ok(productService.create(body));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> read(@PathVariable Long id) {
        log.info("[ExampleController] m=read, id={}", id);
        return ResponseEntity.ok(productService.read(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> fullUpdate(@PathVariable Long id, @RequestBody ProductPayload body) {
        log.info("[ExampleController] m=update, id={}, body={}", id, body);
        return ResponseEntity.ok(productService.updateAll(body, id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductDTO> partialUpdate(@PathVariable Long id, @RequestBody ProductPayload body) {
        log.info("[ExampleController] m=update, id={}, body={}", id, body);
        return ResponseEntity.ok(productService.updateNonNull(body, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("[ExampleController] m=delete, id={}", id);
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
