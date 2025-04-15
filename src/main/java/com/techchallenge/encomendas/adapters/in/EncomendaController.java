package com.techchallenge.encomendas.adapters.in;

import com.techchallenge.encomendas.application.dto.EncomendaDTO;
import com.techchallenge.encomendas.application.dto.NovaEncomendaDTO;
import com.techchallenge.encomendas.application.usecases.encomenda.BuscarEncomendaUseCase;
import com.techchallenge.encomendas.application.usecases.encomenda.RegistrarEncomendaUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/encomendas")
public class EncomendaController {

    private final RegistrarEncomendaUseCase registrarEncomendaUseCase;
    private final BuscarEncomendaUseCase buscarEncomendaUseCase;

    public EncomendaController(RegistrarEncomendaUseCase registrarEncomendaUseCase,
                               BuscarEncomendaUseCase buscarEncomendaUseCase) {
        this.registrarEncomendaUseCase = registrarEncomendaUseCase;
        this.buscarEncomendaUseCase = buscarEncomendaUseCase;
    }

    @PostMapping
    public ResponseEntity<EncomendaDTO> registrarEncomenda(@RequestBody NovaEncomendaDTO novaEncomendaDTO) {
        try {
            EncomendaDTO encomendaDTO = registrarEncomendaUseCase.registrar(novaEncomendaDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(encomendaDTO);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EncomendaDTO> buscarPorId(@PathVariable Long id) {
        try {
            return buscarEncomendaUseCase.buscarPorId(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/morador/{moradorId}")
    public ResponseEntity<List<EncomendaDTO>> buscarPorMorador(@PathVariable Long moradorId) {
        try {
            List<EncomendaDTO> encomendas = buscarEncomendaUseCase.buscarPorMorador(moradorId);
            return ResponseEntity.ok(encomendas);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}/retirada")
    public ResponseEntity<EncomendaDTO> registrarRetirada(@PathVariable Long id) {
        try {
            EncomendaDTO encomendaDTO = registrarEncomendaUseCase.registrarRetirada(id);
            return ResponseEntity.ok(encomendaDTO);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}/confirmar-notificacao")
    public ResponseEntity<EncomendaDTO> confirmarNotificacao(@PathVariable Long id) {
        try {
            boolean sucesso = registrarEncomendaUseCase.confirmarNotificacao(id);
            if (sucesso) {
                return buscarEncomendaUseCase.buscarPorId(id)
                        .map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
