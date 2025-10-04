package Transacao_SpringBoot.core.exception;

//
public class CpfNaoEncontradoException extends RuntimeException {
    public CpfNaoEncontradoException(String message) {
        super(message);
    }
    public CpfNaoEncontradoException() {
        super("CPF não encontrado");
    }
}
