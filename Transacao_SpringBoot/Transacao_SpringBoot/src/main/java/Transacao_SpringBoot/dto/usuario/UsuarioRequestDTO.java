package Transacao_SpringBoot.dto.usuario;

import Transacao_SpringBoot.model.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestDTO {

    @NotBlank(message = "nome obrigatório") @NotNull(message = "nome obrigatório")
    private String nome;

    @NotNull(message = "Data da transação obrigatória")
    @PastOrPresent(message = "A data deve ser passada ou de agora")
    private LocalDate dataCadastro;


    @NotNull(message = "email obrigatório") @NotBlank(message = "email obrigatório")
    @Email(message = "Formato de Email inválido")
    private String email;

    @NotBlank(message = "CPF obrigatório") @NotNull(message = "CPF obrigatório")
    @CPF(message = "Formato de CPF inválido")
    private String cpf;

    public Usuario toUsuario()
    {
        Usuario usuario = new Usuario();

        usuario.setNome(this.nome);
        usuario.setCpf(this.cpf);
        usuario.setEmail(this.email);
        usuario.setDataCadastro(this.dataCadastro);

        return usuario;
    }
}
