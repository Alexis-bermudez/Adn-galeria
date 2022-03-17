package com.ceiba.recibo.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.recibo.modelo.entidad.Recibo;
import com.ceiba.recibo.puerto.repositorio.RepositorioRecibo;
import com.ceiba.recibo.servicio.testdatabuilder.ReciboTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicioCrearReciboTest {

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando se valide la existencia del recibo")
    void deberiaLanzarUnaExcepcionCuandoSeValideLaExistenciaDelRecibo() {
        // arrange
        Recibo recibo = new ReciboTestDataBuilder().conId(1L).build();
        RepositorioRecibo repositorioRecibo = Mockito.mock(RepositorioRecibo.class);
        Mockito.when(repositorioRecibo.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioCrearRecibo servicioCrearRecibo = new ServicioCrearRecibo(repositorioRecibo);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearRecibo.ejecutar(recibo), ExcepcionDuplicidad.class,"El recibo ya existe en el sistema");
    }

    @Test
    @DisplayName("Deberia crear el recibo de manera correcta")
    void deberiaCrearElReciboDeManeraCorrecta() {
        // arrange
        Recibo recibo = new ReciboTestDataBuilder().build();
        RepositorioRecibo repositorioRecibo = Mockito.mock(RepositorioRecibo.class);
        Mockito.when(repositorioRecibo.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioRecibo.crear(recibo)).thenReturn(10L);
        ServicioCrearRecibo servicioCrearRecibo = new ServicioCrearRecibo(repositorioRecibo);
        // act
        Long idRecibo = servicioCrearRecibo.ejecutar(recibo);
        //- assert
        assertEquals(10L, idRecibo);
        Mockito.verify(repositorioRecibo, Mockito.times(1)).crear(recibo);
    }
}
