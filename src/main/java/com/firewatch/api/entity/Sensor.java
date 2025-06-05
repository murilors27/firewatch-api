package com.firewatch.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sensor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sensor_seq")
    @SequenceGenerator(name = "sensor_seq", sequenceName = "SEQ_SENSOR", allocationSize = 1)
    @Column(name = "id_sensor")
    private Long id;

    @Column(name = "tipo", nullable = false)
    private String tipo;
}
