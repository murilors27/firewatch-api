package com.firewatch.api.dto.request;

import jakarta.validation.constraints.NotBlank;

public record SensorRequestDTO(
        @NotBlank(message = "O tipo do sensor é obrigatório")
        String tipo
) {}
