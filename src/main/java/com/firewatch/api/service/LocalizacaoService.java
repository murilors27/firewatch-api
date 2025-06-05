package com.firewatch.api.service;

import com.firewatch.api.dto.request.LocalizacaoRequestDTO;
import com.firewatch.api.dto.response.LocalizacaoResponseDTO;
import com.firewatch.api.entity.*;
import com.firewatch.api.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalizacaoService {

    private final LocalizacaoRepository localizacaoRepository;
    private final CidadeRepository cidadeRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final SensorRepository sensorRepository;
    private final EquipamentoRepository equipamentoRepository;

    public LocalizacaoService(
            LocalizacaoRepository localizacaoRepository,
            CidadeRepository cidadeRepository,
            FuncionarioRepository funcionarioRepository,
            SensorRepository sensorRepository,
            EquipamentoRepository equipamentoRepository
    ) {
        this.localizacaoRepository = localizacaoRepository;
        this.cidadeRepository = cidadeRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.sensorRepository = sensorRepository;
        this.equipamentoRepository = equipamentoRepository;
    }

    public List<LocalizacaoResponseDTO> listar() {
        return localizacaoRepository.findAll().stream()
                .map(LocalizacaoResponseDTO::fromEntity)
                .toList();
    }

    public LocalizacaoResponseDTO buscarPorId(Long id) {
        Localizacao localizacao = localizacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Localização com ID " + id + " não encontrada"));
        return LocalizacaoResponseDTO.fromEntity(localizacao);
    }

    public LocalizacaoResponseDTO cadastrar(LocalizacaoRequestDTO dto) {
        Localizacao localizacao = new Localizacao();
        preencherCampos(localizacao, dto);
        return LocalizacaoResponseDTO.fromEntity(localizacaoRepository.save(localizacao));
    }

    public LocalizacaoResponseDTO atualizar(Long id, LocalizacaoRequestDTO dto) {
        Localizacao localizacao = localizacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Localização com ID " + id + " não encontrada"));
        preencherCampos(localizacao, dto);
        return LocalizacaoResponseDTO.fromEntity(localizacaoRepository.save(localizacao));
    }

    public void deletar(Long id) {
        if (!localizacaoRepository.existsById(id)) {
            throw new RuntimeException("Localização com ID " + id + " não encontrada");
        }
        localizacaoRepository.deleteById(id);
    }

    private void preencherCampos(Localizacao localizacao, LocalizacaoRequestDTO dto) {
        localizacao.setLatitude(dto.latitude());
        localizacao.setLongitude(dto.longitude());
        localizacao.setDataOcorrencia(dto.dataOcorrencia());

        localizacao.setCidade(cidadeRepository.findById(dto.idCidade())
                .orElseThrow(() -> new RuntimeException("Cidade com ID " + dto.idCidade() + " não encontrada")));
        localizacao.setFuncionario(funcionarioRepository.findById(dto.idFuncionario())
                .orElseThrow(() -> new RuntimeException("Funcionário com ID " + dto.idFuncionario() + " não encontrado")));
        localizacao.setSensor(sensorRepository.findById(dto.idSensor())
                .orElseThrow(() -> new RuntimeException("Sensor com ID " + dto.idSensor() + " não encontrado")));
        localizacao.setEquipamentoEmergencia(equipamentoRepository.findById(dto.idEquipamento())
                .orElseThrow(() -> new RuntimeException("Equipamento com ID " + dto.idEquipamento() + " não encontrado")));
    }
}
