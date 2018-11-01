package br.com.analise.compras.exception;

public class ObjectPossuiDependenciaException extends RuntimeException {

    public ObjectPossuiDependenciaException(String msg) {
        super(msg);
    }

    public ObjectPossuiDependenciaException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
