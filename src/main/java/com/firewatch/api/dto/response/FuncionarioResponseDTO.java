package com.firewatch.api.dto.response;

import com.firewatch.api.entity.Funcionario;

public record FuncionarioResponseDTO(
    Long id,
    String nome) {
  public static FuncionarioResponseDTO fromEntity(Funcionario funcionario) {
    return new FuncionarioResponseDTO(
        funcionario.getId(),
        funcionario.getNome());
  }
}