package com.firewatch.api.controller;

import com.firewatch.api.dto.response.LocalizacaoResponseDTO;
import com.firewatch.api.dto.request.LocalizacaoRequestDTO;
import com.firewatch.api.service.LocalizacaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/localizacoes")
@RequiredArgsConstructor
public class LocalizacaoController {

    private final LocalizacaoService service;

    @GetMapping
    public ResponseEntity<List<LocalizacaoResponseDTO>> listarTodas() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocalizacaoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<LocalizacaoResponseDTO> cadastrar(@RequestBody @Valid LocalizacaoRequestDTO dto) {
        return ResponseEntity.status(201).body(service.cadastrar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocalizacaoResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid LocalizacaoRequestDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}