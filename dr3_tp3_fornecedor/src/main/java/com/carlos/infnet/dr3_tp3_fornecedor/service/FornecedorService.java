package com.carlos.infnet.dr3_tp3_fornecedor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.carlos.infnet.dr3_tp3_fornecedor.model.Fornecedor;
import com.carlos.infnet.dr3_tp3_fornecedor.repository.FornecedorRepository;

@Service
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;

    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public Fornecedor create(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public Fornecedor getById(Long id) {
        return fornecedorRepository.findById(id);
    }

    public List<Fornecedor> getAll() {
        return fornecedorRepository.findAll();
    }

    public Fornecedor update(Fornecedor fornecedor) {
        return fornecedorRepository.update(fornecedor);
    }

    public void delete(Long id) {
        fornecedorRepository.deleteById(id);
    }
}
