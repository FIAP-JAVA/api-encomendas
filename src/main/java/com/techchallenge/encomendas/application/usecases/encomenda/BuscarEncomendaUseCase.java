package com.techchallenge.encomendas.application.usecases.encomenda;

import com.techchallenge.encomendas.application.dto.EncomendaDTO;

import java.util.List;
import java.util.Optional;

public interface BuscarEncomendaUseCase {
    Optional<EncomendaDTO> buscarPorId(Long id);
    List<EncomendaDTO> buscarPorMorador(Long idMorador);
}
