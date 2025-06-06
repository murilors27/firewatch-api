package com.firewatch.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "EQUIPAMENTO_EMERGENCIA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipamentoEmergencia {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equipamento_seq")
    @SequenceGenerator(name = "equipamento_seq", sequenceName = "SEQ_EQUIPAMENTO", allocationSize = 1)
    @Column(name = "ID_EQUIPAMENTO_EMERGENCIA")
    private Long id;

    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;
}