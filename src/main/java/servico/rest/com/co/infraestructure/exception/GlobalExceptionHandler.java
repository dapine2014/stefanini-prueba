package servico.rest.com.co.infraestructure.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception ex) {

        log.error("Error no controlado", ex);

        return new ResponseEntity<>("Ha ocurrido un error en el servidor. Por favor, intenta nuevamente.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Opcional: Puedes manejar excepciones más específicas si lo necesitas
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(NullPointerException ex) {
        log.error("Referencia nula", ex);
        return new ResponseEntity<>("Ocurrió un error inesperado: referencia nula.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
