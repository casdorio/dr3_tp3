package com.carlos.infnet.dr3_tp3_produtos.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("produtos")
public class Produto {
    @Id
    private Long id;
    private String nome;
    private double preco;
}
