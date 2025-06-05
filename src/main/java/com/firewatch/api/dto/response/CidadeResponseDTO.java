package com.firewatch.api.dto.response;

public class CidadeResponseDTO {
    private Long id;
    private String nome;
    private String estado;

    // Construtor
    public CidadeResponseDTO(Long id, String nome, String estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEstado() {
        return estado;
    }
}
