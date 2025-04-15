package com.techchallenge.encomendas.application.services.morador;

import com.techchallenge.encomendas.application.dto.MoradorDTO;
import com.techchallenge.encomendas.application.mapper.MoradorMapper;
import com.techchallenge.encomendas.application.usecases.morador.BuscarMoradorUseCase;
import com.techchallenge.encomendas.domain.repositories.MoradorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuscarMoradorService implements BuscarMoradorUseCase {

    private final MoradorRepository moradorRepository;
    private final MoradorMapper moradorMapper;

    public BuscarMoradorService(MoradorRepository moradorRepository,
                                MoradorMapper moradorMapper) {
        this.moradorRepository = moradorRepository;
        this.moradorMapper = moradorMapper;
    }

    @Override
    public Optional<MoradorDTO> buscarPorId(Long id) {
        return moradorRepository.buscarPorId(id)
                .map(moradorMapper::toDTO);
    }

    @Override
    public Optional<MoradorDTO> buscarPorCpf(String cpf) {
        return moradorRepository.buscarPorCpf(cpf)
                .map(moradorMapper::toDTO);
    }

    @Override
    public List<MoradorDTO> buscarPorApartamento(String numeroApartamento) {
        return moradorRepository.buscarPorApartamento(numeroApartamento).stream()
                .map(moradorMapper::toDTO)
                .toList();
    }

    @Override
    public List<MoradorDTO> listarTodosMoradores() {
        return moradorRepository.listarTodosMoradores().stream()
                .map(moradorMapper::toDTO)
                .toList();
    }
}
