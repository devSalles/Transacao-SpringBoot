package Transacao_SpringBoot.model;

import Transacao_SpringBoot.Enum.TipoTransacao;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb__transacao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transacao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) @NotNull @NotBlank
    private String descricao;

    @Column(nullable = false) @NotNull
    private BigDecimal valor;

    @Column(nullable = false) @NotNull
    private LocalDate data;

    @Column(nullable = false) @NotNull @Enumerated(EnumType.STRING)
    private TipoTransacao tipoTransacao;

    //Relacionamento N:1 (várias transações pertencem a um usuário)
    @ManyToOne
    @JoinColumn(name = "usuario_id",nullable = false)
    private Usuario usuario;


}
