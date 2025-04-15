package com.techchallenge.encomendas.adapters.in.handler;

import com.techchallenge.encomendas.domain.exceptions.encomenda.EncomendaNaoEncontradaException;
import com.techchallenge.encomendas.domain.exceptions.morador.MoradorNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MoradorNaoEncontradoException.class)
    public ResponseEntity<?> handleMoradorNaoEncontrado(MoradorNaoEncontradoException ex) {
        return new ResponseEntity<>(buildResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EncomendaNaoEncontradaException.class)
    public ResponseEntity<?> handleEncomendaNaoEncontrada(EncomendaNaoEncontradaException ex) {
        return new ResponseEntity<>(buildResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneric(Exception ex) {
        return new ResponseEntity<>(buildResponse("Erro interno: " + ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private Map<String, Object> buildResponse(String mensagem) {
        return Map.of(
                "timestamp", LocalDateTime.now(),
                "mensagem", mensagem
        );
    }
}
