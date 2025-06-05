package com.firewatch.api.service;

import com.firewatch.api.dto.request.EquipamentoRequestDTO;
import com.firewatch.api.dto.response.EquipamentoResponseDTO;
import com.firewatch.api.entity.EquipamentoEmergencia;
import com.firewatch.api.repository.EquipamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipamentoService {

    private final EquipamentoRepository equipamentoRepository;

    public EquipamentoService(EquipamentoRepository equipamentoRepository) {
        this.equipamentoRepository = equipamentoRepository;
    }

    public List<EquipamentoResponseDTO> listar() {
        return equipamentoRepository.findAll().stream()
                .map(EquipamentoResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public EquipamentoResponseDTO buscarPorId(Long id) {
        EquipamentoEmergencia equipamento = equipamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipamento com ID " + id + " não encontrado"));
        return EquipamentoResponseDTO.fromEntity(equipamento);
    }

    public EquipamentoResponseDTO cadastrar(EquipamentoRequestDTO dto) {
        EquipamentoEmergencia equipamento = new EquipamentoEmergencia();
        equipamento.setNome(dto.nome());

        EquipamentoEmergencia salvo = equipamentoRepository.save(equipamento);
        return EquipamentoResponseDTO.fromEntity(salvo);
    }

    public EquipamentoResponseDTO atualizar(Long id, EquipamentoRequestDTO dto) {
        EquipamentoEmergencia equipamento = equipamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipamento com ID " + id + " não encontrado"));

        equipamento.setNome(dto.nome());
        EquipamentoEmergencia atualizado = equipamentoRepository.save(equipamento);

        return EquipamentoResponseDTO.fromEntity(atualizado);
    }

    public void deletar(Long id) {
        if (!equipamentoRepository.existsById(id)) {
            throw new RuntimeException("Equipamento com ID " + id + " não encontrado");
        }
        equipamentoRepository.deleteById(id);
    }
}
