package Transacao_SpringBoot.core.infra;

import Transacao_SpringBoot.core.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    //Exceção para entrada inválida de dados
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageRestError> entradaDeDadosInvalida(MethodArgumentNotValidException ex)
    {
        String errorMessage =
                ex.getBindingResult().getFieldErrors().stream().map(error->error.getDefaultMessage()).findFirst().orElse("Erro de validação");

        MessageRestError messageRestError = new MessageRestError(HttpStatus.BAD_REQUEST,errorMessage);
        return ResponseEntity.badRequest().body(messageRestError);
    }

    //Exceção para Email já cadastrado
    @ExceptionHandler(EmailExistenteException.class)
    public ResponseEntity<MessageRestError> emailExistente(EmailExistenteException ex)
    {
        MessageRestError messageRestError = new MessageRestError(HttpStatus.CONFLICT,ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(messageRestError);
    }

    //Exceção para Email não encontrado
    @ExceptionHandler(CpfNaoEncontradoException.class)
    public ResponseEntity<MessageRestError> CpfNaoEncontrado(CpfNaoEncontradoException ex)
    {
        MessageRestError messageRestError = new MessageRestError(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageRestError);
    }

    //Exceção para CPF já cadastrado
    @ExceptionHandler(CpfExistenteException.class)
    public ResponseEntity<MessageRestError> CpfExistenteException(CpfExistenteException ex)
    {
        MessageRestError messageRestError = new MessageRestError(HttpStatus.CONFLICT, ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(messageRestError);
    }

    //Exceção para ID não encontrado
    @ExceptionHandler(IdNaoEncontrado.class)
    public ResponseEntity<MessageRestError> idNaoEncontrado(IdNaoEncontrado ex)
    {
        MessageRestError messageRestError = new MessageRestError(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageRestError);
    }

    //Exceção para DB vazio
    @ExceptionHandler(BancoVazioException.class)
    public ResponseEntity<MessageRestError> BancoVazio(BancoVazioException ex)
    {
        MessageRestError messageRestError = new MessageRestError(HttpStatus.NOT_FOUND,ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageRestError);
    }

    //Exceções globais
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageRestError> excecoesGlobais()
    {
        MessageRestError messageRestError = new MessageRestError(HttpStatus.INTERNAL_SERVER_ERROR,"Erro interno, tente novamente mais tarde");
        return ResponseEntity.internalServerError().body(messageRestError);
    }
}
