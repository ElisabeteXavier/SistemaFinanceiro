package br.edu.iftm.jsf.util.exception;

/**
 *
 * @author danilo
 */
public class ErroNegocioException extends Exception {

    public ErroNegocioException(String message) {
        super(message);
    }

    public ErroNegocioException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
