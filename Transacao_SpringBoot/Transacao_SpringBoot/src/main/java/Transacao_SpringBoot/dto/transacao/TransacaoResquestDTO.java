package Transacao_SpringBoot.dto.transacao;

import Transacao_SpringBoot.Enum.TipoTransacao;
import Transacao_SpringBoot.model.Transacao;
import Transacao_SpringBoot.model.Usuario;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransacaoResquestDTO {

    @NotNull(message = "Descrição obrigatória") @NotBlank(message = "Descrição obrigatória")
    private String descricao;

    @NotNull(message = "Valor obrigatório") @DecimalMin(value = "0.01",message = "O preço deve ser maior que 0")
    private BigDecimal valor;

    @NotNull(message = "Data da transação obrigatória") @PastOrPresent(message = "A data deve ser passada ou de agora")
    private LocalDate data;

    @NotNull(message = "Tipo da transação obrigatória") @Enumerated(EnumType.STRING)
    private TipoTransacao tipo;

    @NotNull(message = "Categoria obrigatória") @NotBlank(message = "Categoria obrigatória")
    private String categoria;

    public Transacao toTransacao(Usuario usuario)
    {
        Transacao transacao = new Transacao();

        transacao.setDescricao(this.descricao);
        transacao.setValor(this.valor);
        transacao.setData(this.data);
        transacao.setTipoTransacao(this.tipo);
        transacao.setCategoria(this.categoria);

        if(transacao.getUsuario()==null)
        {
            transacao.setUsuario(usuario);
        }

        return transacao;
    }
}
