package com.firewatch.api.dto.response;

import com.firewatch.api.entity.EquipamentoEmergencia;

public record EquipamentoResponseDTO(Long id, String nome) {
    public static EquipamentoResponseDTO fromEntity(EquipamentoEmergencia equipamento) {
        return new EquipamentoResponseDTO(equipamento.getId(), equipamento.getNome());
    }
}
