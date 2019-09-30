package br.com.amandasomariva.dinersystem.controller.teste;

import br.com.amandasomariva.dinersystem.model.exemplo.Exemplo;
import br.com.amandasomariva.dinersystem.service.exemplo.ExemploService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exemplo")
public class ExemploController {

    private final ExemploService service;

    public ExemploController(ExemploService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Exemplo> findAll(Pageable pageable) {
        return this.service.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exemplo> getById(@PathVariable Long id) {
        return this.service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Exemplo> save(@RequestBody Exemplo exemplo) {
        return this.service.save(exemplo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exemplo> update(@PathVariable Long id, @RequestBody Exemplo exemplo){
        return this.service.upDate(id, exemplo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return this.service.deleteById(id);
    }

}
