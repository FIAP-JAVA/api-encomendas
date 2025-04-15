package com.techchallenge.encomendas.application.dto;

import com.techchallenge.encomendas.domain.enums.Status;

import java.time.LocalDateTime;

public record EncomendaDTO(
        Long id,
        MoradorDTO morador,
        String descricao,
        Status status,
        LocalDateTime dataRecebimento,
        LocalDateTime dataNotificacao,
        LocalDateTime dataConfirmacaoNotificacao,
        LocalDateTime dataRetirada,
        String recebidaPor
) {
}
