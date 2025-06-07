package com.firewatch.api.controller;

import com.firewatch.api.dto.request.EquipamentoRequestDTO;
import com.firewatch.api.dto.response.EquipamentoResponseDTO;
import com.firewatch.api.service.EquipamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/equipamentos")
@Tag(name = "Equipamentos", description = "API para gerenciamento de equipamentos de emergência")
public class EquipamentoController {

    private final EquipamentoService equipamentoService;

    public EquipamentoController(EquipamentoService equipamentoService) {
        this.equipamentoService = equipamentoService;
    }

    @Operation(summary = "Lista todos os equipamentos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de equipamentos retornada com sucesso")
    })
    @GetMapping
    public ResponseEntity<List<EquipamentoResponseDTO>> listar() {
        return ResponseEntity.ok(equipamentoService.listar());
    }

    @Operation(summary = "Busca um equipamento pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Equipamento encontrado"),
            @ApiResponse(responseCode = "404", description = "Equipamento não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<EquipamentoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(equipamentoService.buscarPorId(id));
    }

    @Operation(summary = "Cadastra um novo equipamento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Equipamento cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping
    public ResponseEntity<EquipamentoResponseDTO> cadastrar(@RequestBody @Valid EquipamentoRequestDTO dto) {
        log.info("Recebendo requisição para cadastrar equipamento: {}", dto);
        EquipamentoResponseDTO response = equipamentoService.cadastrar(dto);
        log.info("Equipamento cadastrado com sucesso: {}", response);
        return ResponseEntity.status(201).body(response);
    }

    @Operation(summary = "Atualiza um equipamento existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Equipamento atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "404", description = "Equipamento não encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<EquipamentoResponseDTO> atualizar(@PathVariable Long id,
            @RequestBody @Valid EquipamentoRequestDTO dto) {
        log.info("Recebendo requisição para atualizar equipamento {}: {}", id, dto);
        EquipamentoResponseDTO response = equipamentoService.atualizar(id, dto);
        log.info("Equipamento atualizado com sucesso: {}", response);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Remove um equipamento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Equipamento removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Equipamento não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        log.info("Recebendo requisição para deletar equipamento: {}", id);
        equipamentoService.deletar(id);
        log.info("Equipamento deletado com sucesso");
        return ResponseEntity.noContent().build();
    }
}
