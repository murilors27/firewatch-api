package com.firewatch.api.service;

import com.firewatch.api.dto.request.FuncionarioRequestDTO;
import com.firewatch.api.dto.response.FuncionarioResponseDTO;
import com.firewatch.api.entity.Funcionario;
import com.firewatch.api.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

  private final FuncionarioRepository funcionarioRepository;

  public FuncionarioService(FuncionarioRepository funcionarioRepository) {
    this.funcionarioRepository = funcionarioRepository;
  }

  public List<FuncionarioResponseDTO> listar() {
    return funcionarioRepository.findAll().stream()
        .map(FuncionarioResponseDTO::fromEntity)
        .collect(Collectors.toList());
  }

  public FuncionarioResponseDTO buscarPorId(Long id) {
    Funcionario funcionario = funcionarioRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Funcionário com ID " + id + " não encontrado"));
    return FuncionarioResponseDTO.fromEntity(funcionario);
  }

  public FuncionarioResponseDTO cadastrar(FuncionarioRequestDTO dto) {
    Funcionario funcionario = new Funcionario();
    funcionario.setNome(dto.nome());

    Funcionario salvo = funcionarioRepository.save(funcionario);
    return FuncionarioResponseDTO.fromEntity(salvo);
  }

  public FuncionarioResponseDTO atualizar(Long id, FuncionarioRequestDTO dto) {
    Funcionario funcionario = funcionarioRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Funcionário com ID " + id + " não encontrado"));

    funcionario.setNome(dto.nome());
    Funcionario atualizado = funcionarioRepository.save(funcionario);

    return FuncionarioResponseDTO.fromEntity(atualizado);
  }

  public void deletar(Long id) {
    if (!funcionarioRepository.existsById(id)) {
      throw new RuntimeException("Funcionário com ID " + id + " não encontrado");
    }
    funcionarioRepository.deleteById(id);
  }
}