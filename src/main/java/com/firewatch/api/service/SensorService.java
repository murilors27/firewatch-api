package com.firewatch.api.service;

import com.firewatch.api.dto.request.SensorRequestDTO;
import com.firewatch.api.dto.response.SensorResponseDTO;
import com.firewatch.api.entity.Sensor;
import com.firewatch.api.repository.SensorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SensorService {

    private final SensorRepository sensorRepository;

    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public List<SensorResponseDTO> listar() {
        return sensorRepository.findAll().stream()
                .map(sensor -> new SensorResponseDTO(sensor.getId(), sensor.getTipo()))
                .collect(Collectors.toList());
    }

    public SensorResponseDTO buscarPorId(Long id) {
        Sensor sensor = sensorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sensor com ID " + id + " não encontrado"));
        return new SensorResponseDTO(sensor.getId(), sensor.getTipo());
    }

    public SensorResponseDTO cadastrar(SensorRequestDTO dto) {
        Sensor sensor = new Sensor();
        sensor.setTipo(dto.tipo());

        Sensor salvo = sensorRepository.save(sensor);
        return new SensorResponseDTO(salvo.getId(), salvo.getTipo());
    }

    public SensorResponseDTO atualizar(Long id, SensorRequestDTO dto) {
        Sensor sensor = sensorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sensor com ID " + id + " não encontrado"));

        sensor.setTipo(dto.tipo());
        Sensor atualizado = sensorRepository.save(sensor);

        return new SensorResponseDTO(atualizado.getId(), atualizado.getTipo());
    }

    public void deletar(Long id) {
        if (!sensorRepository.existsById(id)) {
            throw new RuntimeException("Sensor com ID " + id + " não encontrado");
        }
        sensorRepository.deleteById(id);
    }
}
