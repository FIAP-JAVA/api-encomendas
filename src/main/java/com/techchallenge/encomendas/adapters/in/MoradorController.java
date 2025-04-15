package com.techchallenge.encomendas.adapters.in;

import com.techchallenge.encomendas.application.dto.MoradorDTO;
import com.techchallenge.encomendas.application.usecases.morador.BuscarMoradorUseCase;
import com.techchallenge.encomendas.application.usecases.morador.CadastrarMoradorUseCase;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/moradores")
public class MoradorController {

    private final CadastrarMoradorUseCase cadastrarMoradorUseCase;
    private final BuscarMoradorUseCase buscarMoradorUseCase;

    public MoradorController(CadastrarMoradorUseCase cadastrarMoradorUseCase,
                             BuscarMoradorUseCase buscarMoradorUseCase) {
        this.cadastrarMoradorUseCase = cadastrarMoradorUseCase;
        this.buscarMoradorUseCase = buscarMoradorUseCase;
    }

    @PostMapping
    public ResponseEntity<MoradorDTO> cadastrarMorador(@RequestBody MoradorDTO moradorDTO) {
        try {
            MoradorDTO novoMorador = cadastrarMoradorUseCase.cadastrar(moradorDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoMorador);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<MoradorDTO> buscarPorId(@PathVariable Long id) {
        try {
            return buscarMoradorUseCase.buscarPorId(id)
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<MoradorDTO> buscarPorCpf(@RequestParam String cpf) {
        return buscarMoradorUseCase.buscarPorCpf(cpf)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(params = "apartamento")
    public ResponseEntity<List<MoradorDTO>> buscarPorApartamento(@RequestParam String apartamento) {
        var moradores = buscarMoradorUseCase.buscarPorApartamento(apartamento);
        if (moradores.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(moradores);
    }

    @GetMapping
    public ResponseEntity<List<MoradorDTO>> listarTodosMoradores() {
        var moradores = buscarMoradorUseCase.listarTodosMoradores();
        if (moradores.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(moradores);
    }
}
