package com.techchallenge.encomendas.application.usecases.morador;

import com.techchallenge.encomendas.application.dto.MoradorDTO;

import java.util.List;
import java.util.Optional;

public interface BuscarMoradorUseCase {
    Optional<MoradorDTO> buscarPorId(Long id);
    Optional<MoradorDTO> buscarPorCpf(String cpf);
    List<MoradorDTO> buscarPorApartamento(String apartamento);
    List<MoradorDTO> listarTodosMoradores();
}
