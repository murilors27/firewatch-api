package com.firewatch.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "DTO para cadastro/atualização de equipamento de emergência")
public record EquipamentoRequestDTO(
    @Schema(description = "Nome do equipamento", example = "Caminhão de Bombeiros", required = true) @NotBlank(message = "O nome do equipamento é obrigatório") String nome) {
}
