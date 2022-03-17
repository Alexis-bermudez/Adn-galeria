package com.ceiba.recibo.servicio;

import com.ceiba.recibo.puerto.repositorio.RepositorioRecibo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioEliminarReciboTest {

    @Test
    @DisplayName("Deberia eliminar el recibo llamando al repositorio")
    void deberiaEliminarElUsuarioLlamandoAlRepositorio() {
        RepositorioRecibo repositorioRecibo = Mockito.mock(RepositorioRecibo.class);
        ServicioEliminarRecibo servicioEliminarRecibo = new ServicioEliminarRecibo(repositorioRecibo);

        servicioEliminarRecibo.ejecutar(1L);

        Mockito.verify(repositorioRecibo, Mockito.times(1)).eliminar(1L);

    }

}
