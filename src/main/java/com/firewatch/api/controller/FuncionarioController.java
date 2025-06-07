package com.firewatch.api.controller;

import com.firewatch.api.dto.request.FuncionarioRequestDTO;
import com.firewatch.api.dto.response.FuncionarioResponseDTO;
import com.firewatch.api.service.FuncionarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
@RequiredArgsConstructor
@Tag(name = "Funcionários", description = "API para gerenciamento de funcionários")
public class FuncionarioController {

  private final FuncionarioService funcionarioService;

  @Operation(summary = "Lista todos os funcionários")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Lista de funcionários retornada com sucesso")
  })
  @GetMapping
  public ResponseEntity<List<FuncionarioResponseDTO>> listar() {
    return ResponseEntity.ok(funcionarioService.listar());
  }

  @Operation(summary = "Busca um funcionário pelo ID")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Funcionário encontrado"),
      @ApiResponse(responseCode = "404", description = "Funcionário não encontrado")
  })
  @GetMapping("/{id}")
  public ResponseEntity<FuncionarioResponseDTO> buscarPorId(@PathVariable Long id) {
    return ResponseEntity.ok(funcionarioService.buscarPorId(id));
  }

  @Operation(summary = "Cadastra um novo funcionário")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Funcionário cadastrado com sucesso"),
      @ApiResponse(responseCode = "400", description = "Dados inválidos")
  })
  @PostMapping
  public ResponseEntity<FuncionarioResponseDTO> cadastrar(@RequestBody @Valid FuncionarioRequestDTO dto) {
    return ResponseEntity.status(201).body(funcionarioService.cadastrar(dto));
  }

  @Operation(summary = "Atualiza um funcionário existente")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Funcionário atualizado com sucesso"),
      @ApiResponse(responseCode = "400", description = "Dados inválidos"),
      @ApiResponse(responseCode = "404", description = "Funcionário não encontrado")
  })
  @PutMapping("/{id}")
  public ResponseEntity<FuncionarioResponseDTO> atualizar(@PathVariable Long id,
      @RequestBody @Valid FuncionarioRequestDTO dto) {
    return ResponseEntity.ok(funcionarioService.atualizar(id, dto));
  }

  @Operation(summary = "Remove um funcionário")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "204", description = "Funcionário removido com sucesso"),
      @ApiResponse(responseCode = "404", description = "Funcionário não encontrado")
  })
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletar(@PathVariable Long id) {
    funcionarioService.deletar(id);
    return ResponseEntity.noContent().build();
  }
}