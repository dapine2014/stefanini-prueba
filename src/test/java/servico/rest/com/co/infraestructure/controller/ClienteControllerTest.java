package servico.rest.com.co.infraestructure.controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import servico.rest.com.co.application.usecase.ReadClientUseCase;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class ClienteControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ReadClientUseCase readClientUseCase;

    @InjectMocks
    private ClienteController clienteController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(clienteController).build();
    }

    @Test
    public void testGetClientes_IncorrectTypeDoc() throws Exception {
        this.mockMvc.perform(get("/api/clientes/Z/23445322")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Tipo de documento inválido"));
    }

    @Test
    public void testGetClientes_IncorrectCedula() throws Exception {
        this.mockMvc.perform(get("/api/clientes/C/ABCDEFG")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Número de cédula inválido. Deben ser solo números."));
    }

    @Test
    public void testGetClientes_IncorrectPasaporte() throws Exception {
        this.mockMvc.perform(get("/api/clientes/P/ABCDEFG")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Número de pasaporte inválido. Deben ser solo números."));
    }


}