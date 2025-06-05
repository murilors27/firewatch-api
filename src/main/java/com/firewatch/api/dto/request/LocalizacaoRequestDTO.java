package com.firewatch.api.dto.request;

import java.time.LocalDate;

public record LocalizacaoRequestDTO(
        Double latitude,
        Double longitude,
        LocalDate dataOcorrencia,
        Long idCidade,
        Long idFuncionario,
        Long idSensor,
        Long idEquipamento
) {}
