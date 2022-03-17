package com.ceiba.obra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.obra.modelo.entidad.Obra;
import com.ceiba.obra.puerto.repositorio.RepositorioObra;
import com.ceiba.obra.servicio.testdatabuilder.ObraTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicioCrearObraTest {

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando se valide la existencia de la obra")
    void deberiaLanzarUnaExcepcionCuandoSeValideLaExistenciaDeLaObra() {
        // arrange
        Obra obra = new ObraTestDataBuilder().build();
        RepositorioObra repositorioObra = Mockito.mock(RepositorioObra.class);
        Mockito.when(repositorioObra.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearObra servicioCrearObra = new ServicioCrearObra(repositorioObra);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearObra.ejecutar(obra), ExcepcionDuplicidad.class,"La obra ya existe en el sistema");
    }

    @Test
    @DisplayName("Deberia crear la obra de manera correcta")
    void deberiaCrearLaObraDeManeraCorrecta() {
        // arrange
        Obra obra = new ObraTestDataBuilder().build();
        RepositorioObra repositorioObra = Mockito.mock(RepositorioObra.class);
        Mockito.when(repositorioObra.existe(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioObra.crear(obra)).thenReturn(10L);
        ServicioCrearObra servicioCrearObra = new ServicioCrearObra(repositorioObra);
        // act
        Long idObra = servicioCrearObra.ejecutar(obra);
        //- assert
        assertEquals(10L, idObra);
        Mockito.verify(repositorioObra, Mockito.times(1)).crear(obra);
    }
}
