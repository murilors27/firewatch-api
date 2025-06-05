package com.firewatch.api.controller;

import com.firewatch.api.dto.request.CidadeRequestDTO;
import com.firewatch.api.dto.response.CidadeResponseDTO;
import com.firewatch.api.service.CidadeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cidades")
public class CidadeController {

    private final CidadeService cidadeService;

    public CidadeController(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    @GetMapping
    public List<CidadeResponseDTO> listar() {
        return cidadeService.listar();
    }

    @GetMapping("/{id}")
    public CidadeResponseDTO buscar(@PathVariable Long id) {
        return cidadeService.buscarPorId(id);
    }

    @PostMapping
    public CidadeResponseDTO salvar(@RequestBody CidadeRequestDTO dto) {
        return cidadeService.cadastrar(dto);
    }

    @PutMapping("/{id}")
    public CidadeResponseDTO atualizar(@PathVariable Long id, @RequestBody CidadeRequestDTO dto) {
        return cidadeService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        cidadeService.deletar(id);
    }
}
