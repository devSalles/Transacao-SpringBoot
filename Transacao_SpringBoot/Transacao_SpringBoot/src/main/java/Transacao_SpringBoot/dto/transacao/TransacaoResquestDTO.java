package Transacao_SpringBoot.dto.transacao;

import Transacao_SpringBoot.Enum.TipoTransacao;
import Transacao_SpringBoot.model.Transacao;
import Transacao_SpringBoot.model.Usuario;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "Valor obrigatório")
    private BigDecimal valor;

    @NotNull(message = "Data da transação obrigatória")
    private LocalDate data;

    @NotNull(message = "Tipo da transação obrigatória") @Enumerated(EnumType.STRING)
    private TipoTransacao tipo;

    @NotNull(message = "Usuário obrigatório")
    private Usuario usuario;

    public Transacao toTransacao()
    {
        Transacao transacao = new Transacao();

        transacao.setDescricao(this.descricao);
        transacao.setValor(this.valor);
        transacao.setData(this.data);
        transacao.setTipoTransacao(this.tipo);

        if(transacao.getTipoTransacao()!=null)
        {
            transacao.setUsuario(this.usuario);
        }

        return transacao;
    }
}
