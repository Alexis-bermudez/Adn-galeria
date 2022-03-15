package com.ceiba.obra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.obra.modelo.entidad.Obra;
import com.ceiba.obra.puerto.repositorio.RepositorioObra;
import com.ceiba.obra.servicio.testdatabuilder.ObraTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearObraTest {

    @Test
    @DisplayName("Deberia lanzar una exepecion cuando la longitud de la clave sea menor a 4")
    void deberiaLanzarUnaExepcionCuandoLaLongitudDeLaClaveSeaMenorACuatro() {
        // arrange
        ObraTestDataBuilder obraTestDataBuilder = new ObraTestDataBuilder().conClave("124");
        // act - assert
        BasePrueba.assertThrows(obraTestDataBuilder::build, ExcepcionLongitudValor.class, "La clave debe tener una longitud mayor o igual a 4");
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del Usuario")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelUsuario() {
        // arrange
        Obra obra = new ObraTestDataBuilder().build();
        RepositorioObra repositorioObra = Mockito.mock(RepositorioObra.class);
        Mockito.when(repositorioObra.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearObra servicioCrearObra = new ServicioCrearObra(repositorioObra);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearObra.ejecutar(obra), ExcepcionDuplicidad.class,"El usuario ya existe en el sistema");
    }

    @Test
    @DisplayName("Deberia Crear el usuario de manera correcta")
    void deberiaCrearElUsuarioDeManeraCorrecta() {
        // arrange
        Obra obra = new ObraTestDataBuilder().build();
        RepositorioObra repositorioObra = Mockito.mock(RepositorioObra.class);
        Mockito.when(repositorioObra.existe(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioObra.crear(obra)).thenReturn(10L);
        ServicioCrearObra servicioCrearObra = new ServicioCrearObra(repositorioObra);
        // act
        Long idUsuario = servicioCrearObra.ejecutar(obra);
        //- assert
        assertEquals(10L,idUsuario);
        Mockito.verify(repositorioObra, Mockito.times(1)).crear(obra);
    }
}
