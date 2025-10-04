package Transacao_SpringBoot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb__usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) @NotBlank @NotNull
    private String nome;

    @Column(nullable = false,unique = true) @NotBlank @NotNull @CPF
    private String cpf;

    @Column(nullable = false,unique = true) @NotBlank @NotNull @Email
    private String email;

    @Column(nullable = false) @NotNull
    private LocalDate dataCadastro;

    //Relacionamento 1:N (um usuário pode ter várias transações)
    @OneToMany(mappedBy = "usuario")
    private List<Transacao>transacao;
}
