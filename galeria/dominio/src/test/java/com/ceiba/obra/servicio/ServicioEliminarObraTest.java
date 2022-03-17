package com.ceiba.obra.servicio;

import com.ceiba.obra.puerto.repositorio.RepositorioObra;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioEliminarObraTest {

    @Test
    @DisplayName("Deberia eliminar la obra llamando al repositorio")
    void deberiaEliminarLaObraLlamandoAlRepositorio() {
        RepositorioObra repositorioObra = Mockito.mock(RepositorioObra.class);
        ServicioEliminarObra servicioEliminarObra = new ServicioEliminarObra(repositorioObra);

        servicioEliminarObra.ejecutar(1L);

        Mockito.verify(repositorioObra, Mockito.times(1)).eliminar(1L);

    }

}
