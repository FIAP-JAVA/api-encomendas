package com.techchallenge.encomendas.application.usecases.morador;

import com.techchallenge.encomendas.application.dto.MoradorDTO;
import com.techchallenge.encomendas.application.mapper.MoradorMapper;
import com.techchallenge.encomendas.domain.repositories.MoradorRepository;

public interface CadastrarMoradorUseCase {
    MoradorDTO cadastrar(MoradorDTO moradorDTO);
}
