package Transacao_SpringBoot.core.exception;

public class IdNaoEncontrado extends RuntimeException {
    public IdNaoEncontrado(String message) {
        super(message);
    }
    public IdNaoEncontrado() {
        super("Id não encontrado");
    }
}
