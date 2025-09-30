package Transacao_SpringBoot.dto.usuario;

import Transacao_SpringBoot.model.Transacao;
import Transacao_SpringBoot.model.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestDTO {

    @NotBlank(message = "nome obrigatório") @NotNull(message = "nome obrigatório")
    private String nome;

    @NotBlank(message = "CPF obrigatório") @NotNull(message = "CPF obrigatório")
    private String cpf;

    @NotNull(message = "email obrigatório") @NotBlank(message = "email obrigatório")
    private String email;

    @NotNull(message = "Data da transação obrigatória")
    private LocalDate dataCadastro;

    @NotNull(message = "Transação obrigatória")
    private List<Transacao> transacao;

    public Usuario toUsuario()
    {
        Usuario usuario = new Usuario();

        usuario.setNome(this.nome);
        usuario.setCpf(this.cpf);
        usuario.setEmail(this.email);
        usuario.setDataCadastro(this.dataCadastro);

        if(usuario.getTransacao()!=null)
        {
            usuario.setTransacao(this.transacao);
        }

        return usuario;
    }
}
