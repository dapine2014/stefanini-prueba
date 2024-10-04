package servico.rest.com.co.application.dto;

import lombok.Data;

@Data
public class ClienteDto {
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String telefono;
    private String direccion;
    private String ciudadResidencia;
}
