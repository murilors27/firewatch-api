package com.firewatch.api.controller;

import com.firewatch.api.dto.request.SensorRequestDTO;
import com.firewatch.api.dto.response.SensorResponseDTO;
import com.firewatch.api.service.SensorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensores")
public class SensorController {

    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping
    public ResponseEntity<List<SensorResponseDTO>> listar() {
        return ResponseEntity.ok(sensorService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SensorResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(sensorService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<SensorResponseDTO> cadastrar(@RequestBody @Valid SensorRequestDTO dto) {
        return ResponseEntity.ok(sensorService.cadastrar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SensorResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid SensorRequestDTO dto) {
        return ResponseEntity.ok(sensorService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        sensorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
