package Transacao_SpringBoot.repository;

import Transacao_SpringBoot.Enum.TipoTransacao;
import Transacao_SpringBoot.model.Transacao;
import Transacao_SpringBoot.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao,Long> {

    //Lista para exibir transações por usuário
    List<Transacao> findByUsuario(Usuario usuario);

    //Lista para exibir transações por tipo
    List<Transacao> findByUsuarioAndCategoria(Usuario usuario, String categoria);

    //Lista para exixbir as transaçõespor tipo
    List<Transacao> findByUsuarioAndTipoTransacao(Usuario usuario, TipoTransacao tipo);

    //Lista para exibir as transações por data
    List<Transacao> findByUsuarioAndDataBetween(Usuario usuario, LocalDate inicio, LocalDate fim);

    //Metodo responsável por realizar a soma
    default BigDecimal somarPorTipoTransacao(@Param("usuario") Usuario usuario, @Param("tipoTransacao") TipoTransacao tipoTransacao)
    {
        return findByUsuarioAndTipoTransacao(usuario,tipoTransacao).stream().map(Transacao::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
