package Transacao_SpringBoot.dto.usuario;

import Transacao_SpringBoot.model.Usuario;
import java.time.LocalDate;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String CPF,
        String email,
        LocalDate dataCadastro
) {
    public static UsuarioResponseDTO fromUsuario(Usuario usuario)
    {
        return new UsuarioResponseDTO(usuario.getId(),usuario.getNome(),usuario.getCpf(),usuario.getEmail(),usuario.getDataCadastro());
    }
}
