package Transacao_SpringBoot.dto.usuario;

import Transacao_SpringBoot.model.Transacao;
import Transacao_SpringBoot.model.Usuario;

import java.time.LocalDate;
import java.util.List;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String CPF,
        String email,
        LocalDate dataCadastro,
        List<Transacao> transacao
) {
    public UsuarioResponseDTO fromUsuario(Usuario usuario)
    {
        return new UsuarioResponseDTO(usuario.getId(),usuario.getNome(),usuario.getCpf(),usuario.getEmail(),usuario.getDataCadastro(),usuario.getTransacao());
    }
}
