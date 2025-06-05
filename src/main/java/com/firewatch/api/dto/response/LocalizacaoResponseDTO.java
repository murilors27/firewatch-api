package com.firewatch.api.dto.response;

import java.time.LocalDate;

public record LocalizacaoResponseDTO(
        Long id,
        Double latitude,
        Double longitude,
        LocalDate dataOcorrencia,
        CidadeDTO cidade,
        FuncionarioDTO funcionario,
        SensorDTO sensor,
        EquipamentoDTO equipamento
) {
    public static LocalizacaoResponseDTO fromEntity(com.firewatch.api.entity.Localizacao loc) {
        return new LocalizacaoResponseDTO(
                loc.getId(),
                loc.getLatitude(),
                loc.getLongitude(),
                loc.getDataOcorrencia(),
                new CidadeDTO(loc.getCidade().getId(), loc.getCidade().getNome(), loc.getCidade().getEstado()),
                new FuncionarioDTO(loc.getFuncionario().getId(), loc.getFuncionario().getNome()),
                new SensorDTO(loc.getSensor().getId(), loc.getSensor().getTipo()),
                new EquipamentoDTO(loc.getEquipamentoEmergencia().getId(), loc.getEquipamentoEmergencia().getNome())
        );
    }

    public record CidadeDTO(Long id, String nome, String estado) {}
    public record FuncionarioDTO(Long id, String nome) {}
    public record SensorDTO(Long id, String tipo) {}
    public record EquipamentoDTO(Long id, String nome) {}
}
