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

    @PostMapping("/new")
    public ResponseEntity<Object> postUsuario(@Valid @RequestBody UsuarioRequestDTO usuarioRequestDTO)
    {
        return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.postUsuario(usuarioRequestDTO));
    }

    @GetMapping("/show-by-id/{id}")
    public ResponseEntity<Object> showById(@PathVariable Long id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.showByIDUsuario(id));
    }

    @GetMapping("/show-by-cpf/{cpf}")
    public ResponseEntity<Object> showById(@PathVariable String cpf)
    {
        return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.showByCpfUsuario(cpf));
    }

    @GetMapping("/showAll")
    public ResponseEntity<Object> showAll()
    {
        return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.showAll());
    }
}
