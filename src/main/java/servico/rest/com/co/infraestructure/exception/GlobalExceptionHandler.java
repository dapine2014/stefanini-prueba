package servico.rest.com.co.infraestructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception ex) {

        //logger.error("Error no controlado", ex);

        return new ResponseEntity<>("Ha ocurrido un error en el servidor. Por favor, intenta nuevamente.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Opcional: Puedes manejar excepciones más específicas si lo necesitas
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(NullPointerException ex) {
        return new ResponseEntity<>("Ocurrió un error inesperado: referencia nula.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
