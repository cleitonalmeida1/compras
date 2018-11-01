package br.com.analise.compras.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFountException.class)
    public ResponseEntity<StandardError> montarExceptionError(ObjectNotFountException e){
        StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(ObjectPossuiDependenciaException.class)
    public ResponseEntity<StandardError> montarExceptionInternalError(ObjectNotFountException e){
        StandardError error = new StandardError(HttpStatus.FAILED_DEPENDENCY.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body(error);
    }
}
