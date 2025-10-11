package Transacao_SpringBoot.controller;

import Transacao_SpringBoot.dto.usuario.UsuarioRequestDTO;
import Transacao_SpringBoot.service.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
@Tag(name="usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/novo-usuario")
    public ResponseEntity<Object> postUsuario(@Valid @RequestBody UsuarioRequestDTO usuarioRequestDTO)
    {
        return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.postUsuario(usuarioRequestDTO));
    }

    @GetMapping("/listar-id/{id}")
    public ResponseEntity<Object> showById(@PathVariable Long id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.ListarPorID(id));
    }

    @GetMapping("/listar-cpf/{cpf}")
    public ResponseEntity<Object> showById(@PathVariable String cpf)
    {
        return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.ListarPorCPF(cpf));
    }

    @GetMapping("/listar-todos")
    public ResponseEntity<Object> showAll()
    {
        return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.ListarTodos());
    }
}
