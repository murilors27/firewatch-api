package com.firewatch.api.controller;

import com.firewatch.api.dto.request.EquipamentoRequestDTO;
import com.firewatch.api.dto.response.EquipamentoResponseDTO;
import com.firewatch.api.service.EquipamentoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipamentos")
public class EquipamentoController {

    private final EquipamentoService equipamentoService;

    public EquipamentoController(EquipamentoService equipamentoService) {
        this.equipamentoService = equipamentoService;
    }

    @GetMapping
    public List<EquipamentoResponseDTO> listar() {
        return equipamentoService.listar();
    }

    @GetMapping("/{id}")
    public EquipamentoResponseDTO buscarPorId(@PathVariable Long id) {
        return equipamentoService.buscarPorId(id);
    }

    @PostMapping
    public EquipamentoResponseDTO cadastrar(@RequestBody EquipamentoRequestDTO dto) {
        return equipamentoService.cadastrar(dto);
    }

    @PutMapping("/{id}")
    public EquipamentoResponseDTO atualizar(@PathVariable Long id, @RequestBody EquipamentoRequestDTO dto) {
        return equipamentoService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        equipamentoService.deletar(id);
    }
}
