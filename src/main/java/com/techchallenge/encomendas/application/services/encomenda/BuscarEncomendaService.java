package com.techchallenge.encomendas.application.services.encomenda;

import com.techchallenge.encomendas.application.dto.EncomendaDTO;
import com.techchallenge.encomendas.application.mapper.EncomendaMapper;
import com.techchallenge.encomendas.application.usecases.encomenda.BuscarEncomendaUseCase;
import com.techchallenge.encomendas.domain.repositories.EncomendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuscarEncomendaService implements BuscarEncomendaUseCase {

    private final EncomendaRepository encomendaRepository;
    private final EncomendaMapper encomendaMapper;

    public BuscarEncomendaService(EncomendaRepository encomendaRepository,
                                  EncomendaMapper encomendaMapper) {
        this.encomendaRepository = encomendaRepository;
        this.encomendaMapper = encomendaMapper;
    }

    @Override
    public Optional<EncomendaDTO> buscarPorId(Long id) {
        return encomendaRepository.buscarPorId(id)
                .map(encomendaMapper::toDTO);
    }

    @Override
    public List<EncomendaDTO> buscarPorMorador(Long idMorador) {
        return encomendaRepository.buscarPorMorador(idMorador).stream()
                .map(encomendaMapper::toDTO)
                .toList();
    }
}
