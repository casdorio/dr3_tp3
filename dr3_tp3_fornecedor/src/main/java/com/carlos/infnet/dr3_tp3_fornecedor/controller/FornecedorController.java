package com.carlos.infnet.dr3_tp3_fornecedor.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.carlos.infnet.dr3_tp3_fornecedor.model.Fornecedor;
import com.carlos.infnet.dr3_tp3_fornecedor.service.FornecedorService;

@RestController
@RequestMapping("/fornecedores")
@RequiredArgsConstructor
public class FornecedorController {

    private final FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Fornecedor fornecedor) {
        try {
            Fornecedor fornecedorCriado = fornecedorService.create(fornecedor);
            return ResponseEntity.status(HttpStatus.CREATED).body(fornecedorCriado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<Fornecedor>> getAll() {
        Iterable<Fornecedor> fornecedores = fornecedorService.getAll();
        return ResponseEntity.ok(fornecedores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> getById(@PathVariable Long id) {
        try {
            Fornecedor fornecedor = fornecedorService.getById(id);
            return ResponseEntity.ok(fornecedor);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> update(@PathVariable Long id, @RequestBody Fornecedor fornecedorAtualizado) {
        try {
            Fornecedor fornecedor = fornecedorService.update(fornecedorAtualizado);
            return ResponseEntity.ok(fornecedor);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            fornecedorService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
