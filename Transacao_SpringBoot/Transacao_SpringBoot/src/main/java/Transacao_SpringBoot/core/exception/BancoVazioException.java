package Transacao_SpringBoot.core.exception;

public class BancoVazioException extends RuntimeException {
    public BancoVazioException(String message) {
        super(message);
    }
    public BancoVazioException() {
        super("Banco de dados vazio");
    }
}
