package Transacao_SpringBoot.controller;

import Transacao_SpringBoot.Enum.TipoTransacao;
import Transacao_SpringBoot.dto.transacao.TransacaoResquestDTO;
import Transacao_SpringBoot.service.TransacaoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
@RequestMapping("/transacao")
@RequiredArgsConstructor
@Tag(name="transação")
public class TransacaoController {

    private final TransacaoService transacaoService;

    @PostMapping("/nova-transacao/{cpf}")
    public ResponseEntity<Object> newTransacao(@Valid @RequestBody TransacaoResquestDTO transacaoResquestDTO, @PathVariable String cpf)
    {
        return ResponseEntity.ok(this.transacaoService.postTransacao(transacaoResquestDTO,cpf));
    }

    @GetMapping("/usuario-cpf/{cpf}")
    public ResponseEntity<Object> listarPorUsuario(@PathVariable String cpf)
    {
        return ResponseEntity.ok(this.transacaoService.listarPorUsuario(cpf));
    }

    @GetMapping("/listar-categoria/{cpf}/{categoria}")
    public ResponseEntity<Object> listarPorCategoria(@PathVariable String cpf,@PathVariable String categoria)
    {
        return ResponseEntity.ok(this.transacaoService.listarPorCategoria(cpf,categoria));
    }

    @GetMapping("/tipo/{cpf}/{tipoTransacao}")
    public ResponseEntity<Object> listarPortipo(@PathVariable String cpf, @PathVariable TipoTransacao tipoTransacao)
    {
        return ResponseEntity.ok(this.transacaoService.listarPorTipo(cpf,tipoTransacao));
    }

    @GetMapping("/data/{cpf}/{inicio}/{fim}")
    public ResponseEntity<Object> listarPorUsuario(@PathVariable String cpf, @PathVariable LocalDate inicio, @PathVariable LocalDate fim)
    {
        return ResponseEntity.ok(this.transacaoService.listarPorData(cpf,inicio,fim));
    }

    @GetMapping("/listar-todos")
    public ResponseEntity<Object> listarTodos()
    {
        return ResponseEntity.ok(this.transacaoService.buscarTodos());
    }

    @GetMapping("/saldo/{cpf}")
    public ResponseEntity<Object> saldoTotal(@PathVariable String cpf)
    {
        return ResponseEntity.ok(this.transacaoService.calcularSaldo(cpf));
    }
}
