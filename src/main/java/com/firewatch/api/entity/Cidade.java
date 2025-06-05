package com.firewatch.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "cidade")
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cidade_seq")
    @SequenceGenerator(name = "cidade_seq", sequenceName = "SEQ_CIDADE", allocationSize = 1)
    @Column(name = "id_cidade")
    private Long id;

    @Column(name = "nome_cidade")
    private String nome;

    private String estado;
}
