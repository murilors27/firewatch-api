package com.firewatch.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "CIDADE")
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cidade_seq")
    @SequenceGenerator(name = "cidade_seq", sequenceName = "SEQ_CIDADE", allocationSize = 1)
    @Column(name = "ID_CIDADE")
    private Long id;

    @Column(name = "NOME_CIDADE", nullable = false)
    private String nome;

    @Column(name = "ESTADO")
    private String estado;
}
