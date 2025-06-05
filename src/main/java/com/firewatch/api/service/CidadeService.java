package com.firewatch.api.service;

import com.firewatch.api.dto.request.CidadeRequestDTO;
import com.firewatch.api.dto.response.CidadeResponseDTO;
import com.firewatch.api.entity.Cidade;
import com.firewatch.api.repository.CidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CidadeService {

    private final CidadeRepository cidadeRepository;

    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    public List<CidadeResponseDTO> listar() {
        return cidadeRepository.findAll().stream()
                .map(cidade -> new CidadeResponseDTO(cidade.getId(), cidade.getNome(), cidade.getEstado()))
                .collect(Collectors.toList());
    }

    public CidadeResponseDTO buscarPorId(Long id) {
        Cidade cidade = cidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cidade com ID " + id + " não encontrada"));
        return new CidadeResponseDTO(cidade.getId(), cidade.getNome(), cidade.getEstado());
    }

    public CidadeResponseDTO cadastrar(CidadeRequestDTO dto) {
        Cidade cidade = new Cidade();
        cidade.setNome(dto.getNome());
        cidade.setEstado(dto.getEstado());

        Cidade salva = cidadeRepository.save(cidade);
        return new CidadeResponseDTO(salva.getId(), salva.getNome(), salva.getEstado());
    }

    public CidadeResponseDTO atualizar(Long id, CidadeRequestDTO dto) {
        Cidade cidade = cidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cidade com ID " + id + " não encontrada"));

        cidade.setNome(dto.getNome());
        cidade.setEstado(dto.getEstado());

        Cidade atualizada = cidadeRepository.save(cidade);
        return new CidadeResponseDTO(atualizada.getId(), atualizada.getNome(), atualizada.getEstado());
    }

    public void deletar(Long id) {
        if (!cidadeRepository.existsById(id)) {
            throw new RuntimeException("Cidade com ID " + id + " não encontrada");
        }
        cidadeRepository.deleteById(id);
    }
}