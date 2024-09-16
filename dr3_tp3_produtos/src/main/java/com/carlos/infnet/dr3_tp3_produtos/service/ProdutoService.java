package com.carlos.infnet.dr3_tp3_produtos.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.carlos.infnet.dr3_tp3_produtos.model.Produto;
import com.carlos.infnet.dr3_tp3_produtos.repository.ProdutoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public Mono<Produto> create(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Flux<Produto> getAll() {
        return produtoRepository.findAll();
    }

    public Mono<Produto> getById(Long id) {
        return produtoRepository.findById(id);
    }

    public Mono<Produto> update(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Mono<Void> deleteById(Long id) {
        return produtoRepository.deleteById(id);
    }
}
