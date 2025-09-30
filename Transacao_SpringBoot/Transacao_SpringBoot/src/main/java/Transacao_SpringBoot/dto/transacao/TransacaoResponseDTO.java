package Transacao_SpringBoot.dto.transacao;

import Transacao_SpringBoot.Enum.TipoTransacao;
import Transacao_SpringBoot.model.Transacao;
import Transacao_SpringBoot.model.Usuario;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransacaoResponseDTO(
        Long id ,
        String descricao,
        BigDecimal valor,
        LocalDate data,
        TipoTransacao tipoTransacao,
        Usuario usuario
) {
    public TransacaoResponseDTO fromTransacao(Transacao transacao)
    {
        return new TransacaoResponseDTO(
                transacao.getId(),transacao.getDescricao(),transacao.getValor(),transacao.getData(),transacao.getTipoTransacao(),transacao.getUsuario());
    }
}
