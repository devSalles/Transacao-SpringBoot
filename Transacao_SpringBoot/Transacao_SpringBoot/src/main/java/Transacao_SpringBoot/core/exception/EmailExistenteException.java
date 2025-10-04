package Transacao_SpringBoot.core.exception;

public class EmailExistenteException extends RuntimeException {
    public EmailExistenteException(String message) {
        super(message);
    }
    public EmailExistenteException() {
        super("Email já cadastrado");
    }
}
