package com.ceiba.recibo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.recibo.modelo.entidad.Recibo;
import com.ceiba.recibo.servicio.testdatabuilder.ReciboTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ReciboTest {

    @Test
    @DisplayName("Deberia crear correctamente el recibo para obra de realismo")
    void deberiaCrearCorrectamenteElReciboDeRealismo() {
        // arrange

        //act
        Recibo recibo = new ReciboTestDataBuilder().conId(1L).build();

        //assert
        assertEquals(1, recibo.getId());
        assertEquals(3600000, recibo.getTotal());
        assertFalse(recibo.getEntregaInmediata());
        assertEquals(LocalDate.now(), recibo.getFechaCompra());
        assertEquals(LocalDate.now().plusDays(15), recibo.getFechaEntrega());
        assertEquals("REALISMO", recibo.getTipoObra());
        assertEquals(1, recibo.getIdObra());
    }

    @Test
    @DisplayName("Deberia crear correctamente el recibo para obra de surrealismo")
    void deberiaCrearCorrectamenteElReciboDeSurrealismo() {
        // arrange

        //act
        Recibo recibo = new ReciboTestDataBuilder().conTipoObra("SURREALISMO").conId(1L).build();

        //assert
        assertEquals(1, recibo.getId());
        assertEquals(3600000, recibo.getTotal());
        assertFalse(recibo.getEntregaInmediata());
        assertEquals(LocalDate.now(), recibo.getFechaCompra());
        assertEquals(LocalDate.now().plusDays(10), recibo.getFechaEntrega());
        assertEquals("SURREALISMO", recibo.getTipoObra());
        assertEquals(1, recibo.getIdObra());
    }

    @Test
    @DisplayName("Deberia crear correctamente el recibo para obra abstracto")
    void deberiaCrearCorrectamenteElReciboDeAbstracto() {
        // arrange

        //act
        Recibo recibo = new ReciboTestDataBuilder().conTipoObra("ABSTRACTO").conId(1L).build();

        //assert
        assertEquals(1, recibo.getId());
        assertEquals(3600000, recibo.getTotal());
        assertFalse(recibo.getEntregaInmediata());
        assertEquals(LocalDate.now(), recibo.getFechaCompra());
        assertEquals(LocalDate.now().plusDays(7), recibo.getFechaEntrega());
        assertEquals("ABSTRACTO", recibo.getTipoObra());
        assertEquals(1, recibo.getIdObra());
    }

    @Test
    void deberiaFallarSinTotal() {

        //Arrange
        ReciboTestDataBuilder reciboTestDataBuilder = new ReciboTestDataBuilder().conTotal(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    reciboTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el total a pagar por la obra");
    }

    @Test
    void deberiaFallarSinEntregaInmediata() {

        //Arrange
        ReciboTestDataBuilder reciboTestDataBuilder = new ReciboTestDataBuilder().conEntregaInmediata(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    reciboTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar si la entrega se realiza inmediatamente");
    }

    @Test
    @DisplayName("Deberia crear correctamente el recibo para obra de surrealismo")
    void deberiaCambiarFechaCompraNulaAFechaActual() {
        // arrange

        //act
        Recibo recibo = new ReciboTestDataBuilder().conFechaCompra(null).conTipoObra("SURREALISMO").conId(1L).build();

        //assert
        assertEquals(1, recibo.getId());
        assertEquals(3600000, recibo.getTotal());
        assertFalse(recibo.getEntregaInmediata());
        assertEquals(LocalDate.now(), recibo.getFechaCompra());
        assertEquals(LocalDate.now().plusDays(10), recibo.getFechaEntrega());
        assertEquals("SURREALISMO", recibo.getTipoObra());
        assertEquals(1, recibo.getIdObra());
    }

    @Test
    void deberiaFallarSinTipoObra() {

        //Arrange
        ReciboTestDataBuilder reciboTestDataBuilder = new ReciboTestDataBuilder().conTipoObra(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    reciboTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el tipo de obra");
    }

    @Test
    void deberiaFallarSinIdObraVendida() {

        //Arrange
        ReciboTestDataBuilder reciboTestDataBuilder = new ReciboTestDataBuilder().conIdObra(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    reciboTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el id de la obra vendida");
    }

    @Test
    void deberiaFallarConTipoDeObraDistintoARealismoSurrealismoAbstracto() {

        //Arrange
        ReciboTestDataBuilder reciboTestDataBuilder = new ReciboTestDataBuilder().conTipoObra("IMPRESIONISMO").conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    reciboTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "Tipo de obra no admitido");
    }

    // REGLA DE NEGOCIO #1
    @Test
    void deberiaCrearReciboSinEntregaInmediataYSinCobroExtra() {

        //Arrange
        ReciboTestDataBuilder reciboTestDataBuilder = new ReciboTestDataBuilder().conEntregaInmediata(false).conId(1L);
        //act
        Recibo recibo = reciboTestDataBuilder.build();
        //assert
        assertEquals(LocalDate.now(), recibo.getFechaCompra());
        assertEquals(LocalDate.now().plusDays(15), recibo.getFechaEntrega());
        assertEquals(3600000L, recibo.getTotal());
    }

    // REGLA DE NEGOCIO #2
    @Test
    void deberiaCrearReciboConEntregaInmediataYCostoExtra() {

        //Arrange
        ReciboTestDataBuilder reciboTestDataBuilder = new ReciboTestDataBuilder().conEntregaInmediata(true).conId(1L);
        //act
        Recibo recibo = reciboTestDataBuilder.build();
        //assert
        assertEquals(LocalDate.now(), recibo.getFechaCompra());
        assertEquals(LocalDate.now(), recibo.getFechaEntrega());
        assertEquals((long) (3600000*1.10), recibo.getTotal());
    }

    // REGLA DE NEGOCIO #3
    @Test
    void deberiaFallarSiFechaCompraEsSabado() {

        //Arrange
        ReciboTestDataBuilder reciboTestDataBuilder = new ReciboTestDataBuilder().conFechaCompra(LocalDate.of(2022,3,19)).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    reciboTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "No se puede vender los días sábados");
    }
}
