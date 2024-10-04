package servico.rest.com.co.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import servico.rest.com.co.application.usecase.ReadClientUseCase;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ReadClientUseCase readClientUseCase;


    @GetMapping("/{tipoDocumento}/{numeroDocumento}")
    public ResponseEntity<Object> getClientes(@PathVariable String tipoDocumento, @PathVariable String numeroDocumento) {
        if (!tipoDocumento.equals("C") && !tipoDocumento.equals("P")) {
            return new ResponseEntity<>("Tipo de documento inválido", HttpStatus.BAD_REQUEST);
        }

        // Validación del formato del número de documento
        if (tipoDocumento.equals("C") && !numeroDocumento.matches("\\d+")) {
            return new ResponseEntity<>("Número de cédula inválido. Deben ser solo números.", HttpStatus.BAD_REQUEST);
        }

        if (tipoDocumento.equals("P") && !numeroDocumento.matches("\\d+")) {
            return new ResponseEntity<>("Número de pasaporte inválido. Deben ser solo números.", HttpStatus.BAD_REQUEST);
        }

        // Simulación de un error 500 para pruebas
        if (numeroDocumento.equals("8080")) {
            throw new RuntimeException("Simulación de un error interno del servidor");
        }

        // Validación del número de documento específico
        if (!numeroDocumento.equals("23445322")) {
            return new ResponseEntity<>("Cliente no encontrado", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(readClientUseCase.readCliente(), HttpStatus.OK);
    }

}
