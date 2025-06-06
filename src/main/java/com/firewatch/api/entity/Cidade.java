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

    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @Column(name = "ESTADO", length = 2)
    private String estado;
}
