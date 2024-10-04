package servico.rest.com.co.infraestructure.out.Repository;


import org.springframework.stereotype.Repository;
import servico.rest.com.co.domain.ClientEntity;

@Repository
public class ClientRepository {
    public ClientEntity getAllClients() {

        return ClientEntity.builder()
                .id(1L)
                .primerNombre("alexander")
                .segundoNombre("")
                .primerApellido("Pineda")
                .segundoApellido("Guzman")
                .documento("23445322")
                .pasaporte("BA128190")
                .telefono("3203009984")
                .direccion("cll 36b sur ")
                .ciudadResidencia("Bogota").build();
    }
}
