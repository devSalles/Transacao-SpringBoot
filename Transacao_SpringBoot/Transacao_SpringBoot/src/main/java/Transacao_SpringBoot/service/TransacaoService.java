package Transacao_SpringBoot.service;

import Transacao_SpringBoot.Enum.TipoTransacao;
import Transacao_SpringBoot.core.exception.BancoVazioException;
import Transacao_SpringBoot.core.exception.CpfNaoEncontradoException;
import Transacao_SpringBoot.dto.transacao.TransacaoResquestDTO;
import Transacao_SpringBoot.model.Transacao;
import Transacao_SpringBoot.model.Usuario;
import Transacao_SpringBoot.repository.TransacaoRepository;
import Transacao_SpringBoot.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Service
@RequiredArgsConstructor
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;
    private final UsuarioRepository usuarioRepository;

    //Metodo responsável por salvar transação
    @Transactional
    public Transacao postTransacao(TransacaoResquestDTO transacaoResquestDTO,String cpf)
    {
        Usuario usuarioCPF= buscaPorCPF(cpf);

        //Bloco de código responsável por adicionar ou remover valor
        if(transacaoResquestDTO.getTipo() == TipoTransacao.DESPESA)
        {
            if(transacaoResquestDTO.getValor().compareTo(usuarioCPF.getSaldo())>0)
            {
                throw new IllegalArgumentException("Saldo insuficiente");
            }

            usuarioCPF.setSaldo(usuarioCPF.getSaldo().subtract(transacaoResquestDTO.getValor()));
        }
        else if(transacaoResquestDTO.getTipo() == TipoTransacao.RECEITA)
        {
            usuarioCPF.setSaldo(usuarioCPF.getSaldo().add(transacaoResquestDTO.getValor()));
        }

        Transacao transacao = transacaoResquestDTO.toTransacao(usuarioCPF);
        this.usuarioRepository.save(usuarioCPF);
        return this.transacaoRepository.save(transacao);
    }

    public List<Transacao> listarPorUsuario(String cpf)
    {
        Usuario usuarioCPF = buscaPorCPF(cpf);

        return transacaoRepository.findByUsuario(usuarioCPF);
    }

    public List<Transacao> listarPorCategoria(String cpf,String categoria)
    {
        Usuario usuarioCPF = buscaPorCPF(cpf);

        return this.transacaoRepository.findByUsuarioAndCategoria(usuarioCPF,categoria);
    }

    //Listagem por tipo de transação
    public List<Transacao> listarPorTipo(String cpf, TipoTransacao tipoTransacao)
    {
        Usuario usuarioCPF = buscaPorCPF(cpf);

        return this.transacaoRepository.findByUsuarioAndTipoTransacao(usuarioCPF,tipoTransacao);
    }

    public List<Transacao> listarPorData(String cpf, LocalDate inicio,LocalDate fim)
    {
        Usuario usuarioCPF = buscaPorCPF(cpf);

        return this.transacaoRepository.findByUsuarioAndDataBetween(usuarioCPF,inicio,fim);
    }

    //Listagem de todos os registros de transação
    public List<Transacao> buscarTodos()
    {
        List<Transacao>listarTodos=this.transacaoRepository.findAll();

        if(listarTodos.isEmpty())
        {
            throw new BancoVazioException();
        }

        //Retorna todas as transações
        return listarTodos;
    }

    //Metodo responsável por calcular o saldo
    public BigDecimal calcularSaldo(String cpf)
    {
        Usuario usuarioCPF = buscaPorCPF(cpf);

        //Calcula o total de receitas e despesas
        BigDecimal receita = this.transacaoRepository.somarPorTipoTransacao(usuarioCPF, TipoTransacao.RECEITA);
        BigDecimal despesa = this.transacaoRepository.somarPorTipoTransacao(usuarioCPF, TipoTransacao.DESPESA);

        //Caso receita ou despesa seja 0
        if(receita == null)
        {
            return receita = BigDecimal.ZERO;
        }
        if(despesa == null )
        {
            return despesa = BigDecimal.ZERO;
        }

        BigDecimal saldo = receita.subtract(despesa);

        usuarioCPF.setSaldo(saldo);
        this.usuarioRepository.save(usuarioCPF);

        //Retorna saldo do usuário
        return saldo;
    }

    //Metodo responsável por realizar busca por CPF
    public Usuario buscaPorCPF(String cpf)
    {
        Usuario usuarioCPF = this.usuarioRepository.findByCpf(cpf);

        if(usuarioCPF==null)
        {
            throw new CpfNaoEncontradoException();
        }

        return usuarioCPF;
    }

}