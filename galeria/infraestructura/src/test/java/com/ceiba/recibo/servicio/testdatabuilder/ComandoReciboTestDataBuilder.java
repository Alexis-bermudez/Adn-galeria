package com.ceiba.recibo.servicio.testdatabuilder;

import com.ceiba.recibo.comando.ComandoRecibo;

import java.time.LocalDate;

public class ComandoReciboTestDataBuilder {

    private Long id;
    private Long total;
    private Boolean entregaInmediata;
    private LocalDate fechaCompra;
    private LocalDate fechaEntrega;
    private String tipoObra;
    private Long idObra;

    public ComandoReciboTestDataBuilder() {
        total = 3600000L;
        entregaInmediata = false;
        fechaCompra = LocalDate.now();
        fechaEntrega = entregaInmediata ? LocalDate.now() : LocalDate.now().plusDays(15);
        tipoObra = "REALISMO";
        idObra = 1L;
    }

    public ComandoReciboTestDataBuilder conTotal_EntregaInmediata_IdObra(Long total, Boolean entregaInmediata, Long idObra) {
        this.total = total;
        this.entregaInmediata = entregaInmediata;
        this.fechaEntrega = entregaInmediata ? LocalDate.now() : LocalDate.now().plusDays(15);
        this.idObra = idObra;
        return this;
    }

    public ComandoRecibo build() {
        return new ComandoRecibo(id, total, entregaInmediata, fechaCompra, fechaEntrega, tipoObra, idObra);
    }
}
