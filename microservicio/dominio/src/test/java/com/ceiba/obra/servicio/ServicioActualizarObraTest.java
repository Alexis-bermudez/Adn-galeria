package com.ceiba.obra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.obra.modelo.entidad.Obra;
import com.ceiba.obra.puerto.repositorio.RepositorioObra;
import com.ceiba.obra.servicio.testdatabuilder.ObraTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioActualizarObraTest {

    @Test
    @DisplayName("Deberia validar la existencia previa de la obra")
    void deberiaValidarLaExistenciaPreviaDeLaObra() {
        // arrange
        Obra obra = new ObraTestDataBuilder().conId(1L).build();
        RepositorioObra repositorioObra = Mockito.mock(RepositorioObra.class);
        Mockito.when(repositorioObra.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarObra servicioActualizarObra = new ServicioActualizarObra(repositorioObra);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarObra.ejecutar(obra), ExcepcionDuplicidad.class,"La obra no existe en el sistema");
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        Obra obra = new ObraTestDataBuilder().conId(1L).build();
        RepositorioObra repositorioObra = Mockito.mock(RepositorioObra.class);
        Mockito.when(repositorioObra.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarObra servicioActualizarObra = new ServicioActualizarObra(repositorioObra);
        // act
        servicioActualizarObra.ejecutar(obra);
        //assert
        Mockito.verify(repositorioObra,Mockito.times(1)).actualizar(obra);
    }
}
