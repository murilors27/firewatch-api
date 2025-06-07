package com.firewatch.api.dto.request;

import jakarta.validation.constraints.NotBlank;

public record EquipamentoRequestDTO(
    @NotBlank(message = "O nome do equipamento é obrigatório") String nome
) {}
