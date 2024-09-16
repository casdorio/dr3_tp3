package com.carlos.infnet.dr3_tp3_produtos.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.carlos.infnet.dr3_tp3_produtos.model.Produto;

import reactor.core.publisher.Flux;

public interface ProdutoRepository extends ReactiveCrudRepository<Produto, Long> {
    Flux<Produto> findByNomeContaining(String nome);
}
