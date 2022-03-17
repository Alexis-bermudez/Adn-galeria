package com.ceiba.recibo.controlador;

import com.ceiba.ApplicationMock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ConsultaControladorRecibo.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ConsultaControladorReciboTest {

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia listar recibos")
    void deberiaListarRecibos() throws Exception {
        // arrange
        // act - assert
        mocMvc.perform(get("/recibos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].total", is(3600000)))
                .andExpect(jsonPath("$[0].entregaInmediata", is(false)))
                .andExpect(jsonPath("$[0].fechaCompra", is(LocalDate.of(2022, 3, 16).toString())))
                .andExpect(jsonPath("$[0].fechaEntrega", is(LocalDate.of(2022, 3, 31).toString())))
                .andExpect(jsonPath("$[0].tipoObra", is("REALISMO")))
                .andExpect(jsonPath("$[0].idObra", is(1)));

    }


}
