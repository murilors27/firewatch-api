package com.firewatch.api.dto.request;

import jakarta.validation.constraints.NotBlank;

public record FuncionarioRequestDTO(
    @NotBlank(message = "O nome do funcionário é obrigatório") String nome) {
}