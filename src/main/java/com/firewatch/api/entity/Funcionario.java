package com.firewatch.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "funcionario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionario_seq")
    @SequenceGenerator(name = "funcionario_seq", sequenceName = "SEQ_FUNCIONARIO", allocationSize = 1)
    @Column(name = "id_funcionario")
    private Long id;

    @Column(name = "nome_funcionario", nullable = false)
    private String nome;
}
