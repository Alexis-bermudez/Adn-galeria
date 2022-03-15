package com.ceiba.obra.servicio;

import com.ceiba.obra.puerto.repositorio.RepositorioObra;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarObraTest {

    @Test
    @DisplayName("Deberia eliminar el usuario llamando al repositorio")
    void deberiaEliminarElUsuarioLlamandoAlRepositorio() {
        RepositorioObra repositorioObra = Mockito.mock(RepositorioObra.class);
        ServicioEliminarObra servicioEliminarObra = new ServicioEliminarObra(repositorioObra);

        servicioEliminarObra.ejecutar(1l);

        Mockito.verify(repositorioObra, Mockito.times(1)).eliminar(1l);

    }

}
