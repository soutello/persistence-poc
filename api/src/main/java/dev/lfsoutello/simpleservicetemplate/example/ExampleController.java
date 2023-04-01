package dev.lfsoutello.simpleservicetemplate.example;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/example")
public class ExampleController {
    private final ExampleService exampleService;

    @PostMapping
    public ResponseEntity<ExampleDTO> create(@RequestBody ExampleForm body) {
        log.info("[ExampleController] m=create, body={}", body);
        return ResponseEntity.ok(exampleService.create(body.getText()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExampleDTO> read(@PathVariable Long id) {
        log.info("[ExampleController] m=read, id={}", id);
        return ResponseEntity.ok(exampleService.read(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExampleDTO> update(@PathVariable Long id, @RequestBody ExampleForm body) {
        log.info("[ExampleController] m=update, id={}, body={}", id, body);
        return ResponseEntity.ok(exampleService.update(id, body.getText()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("[ExampleController] m=delete, id={}", id);
        exampleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
