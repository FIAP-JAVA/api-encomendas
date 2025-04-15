package com.techchallenge.encomendas.domain.entities;

import com.techchallenge.encomendas.domain.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "encomendas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Encomenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "morador_id")
    private Morador morador;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime dataRecebimento;
    private LocalDateTime dataNotificacao;
    private LocalDateTime dataConfirmacaoNotificacao;
    private LocalDateTime dataRetirada;
    private String recebidaPor;
}
