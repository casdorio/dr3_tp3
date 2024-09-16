package com.carlos.infnet.dr3_tp3_fornecedor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("fornecedores")
public class Fornecedor {

    @Id
    private Long id;
    private String nome;
    private String cnpj;
    private String email;
}
