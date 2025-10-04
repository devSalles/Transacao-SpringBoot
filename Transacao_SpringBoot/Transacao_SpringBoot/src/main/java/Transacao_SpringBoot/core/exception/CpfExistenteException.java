package Transacao_SpringBoot.core.exception;

public class CpfExistenteException extends RuntimeException {
    public CpfExistenteException(String message) {
        super(message);
    }

    public CpfExistenteException() {
        super("CPF já cadastrado");
    }
}
