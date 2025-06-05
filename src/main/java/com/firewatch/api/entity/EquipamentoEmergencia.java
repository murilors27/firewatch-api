package com.firewatch.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "equipamento_emergencia")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipamentoEmergencia {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equipamento_seq")
    @SequenceGenerator(name = "equipamento_seq", sequenceName = "SEQ_EQUIPAMENTO", allocationSize = 1)
    @Column(name = "id_equipamento_emergencia")
    private Long id;

    @Column(name = "nome_equipamento", nullable = false)
    private String nome;
}