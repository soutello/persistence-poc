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
    private final ProductBasicService productBasicService;

    private final ProductStockService productStockService;

    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody ProductPayload body) {
        log.info("[{}] m=create, body={}", this.getClass().getSimpleName(), body);
        return ResponseEntity.ok(productBasicService.create(body));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> read(@PathVariable Long id) {
        log.info("[{}] m=read, id={}", this.getClass().getSimpleName(), id);
        return ResponseEntity.ok(productBasicService.read(id));
    }

    @PatchMapping("/{id}/stock")
    public ResponseEntity<ProductDTO> addToStock(@PathVariable Long id, @RequestBody AddStockPayload payload) {
        log.info("[{}] m=addToStock, id={}, payload={}", this.getClass().getSimpleName(), id, payload);
        return ResponseEntity.ok(productStockService.addToStock(id, payload.getAddQuantity()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("[{}] m=delete, id={}", this.getClass().getSimpleName(), id);
        productBasicService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
