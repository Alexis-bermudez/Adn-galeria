package com.ceiba.recibo.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.recibo.modelo.entidad.Recibo;
import com.ceiba.recibo.puerto.repositorio.RepositorioRecibo;
import com.ceiba.recibo.servicio.testdatabuilder.ReciboTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioActualizarReciboTest {

    @Test
    @DisplayName("Deberia validar la existencia previa del recibo")
    void deberiaValidarLaExistenciaPreviaDelRecibo() {
        // arrange
        Recibo recibo = new ReciboTestDataBuilder().conId(1L).build();
        RepositorioRecibo repositorioRecibo = Mockito.mock(RepositorioRecibo.class);
        Mockito.when(repositorioRecibo.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarRecibo servicioActualizarRecibo = new ServicioActualizarRecibo(repositorioRecibo);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarRecibo.ejecutar(recibo), ExcepcionDuplicidad.class,"El recibo no existe en el sistema");
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        Recibo recibo = new ReciboTestDataBuilder().conId(1L).build();
        RepositorioRecibo repositorioRecibo = Mockito.mock(RepositorioRecibo.class);
        Mockito.when(repositorioRecibo.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarRecibo servicioActualizarRecibo = new ServicioActualizarRecibo(repositorioRecibo);
        // act
        servicioActualizarRecibo.ejecutar(recibo);
        //assert
        Mockito.verify(repositorioRecibo,Mockito.times(1)).actualizar(recibo);
    }
}