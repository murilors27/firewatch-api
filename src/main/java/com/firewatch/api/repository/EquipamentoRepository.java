package com.firewatch.api.repository;

import com.firewatch.api.entity.EquipamentoEmergencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipamentoRepository extends JpaRepository<EquipamentoEmergencia, Long> {}
