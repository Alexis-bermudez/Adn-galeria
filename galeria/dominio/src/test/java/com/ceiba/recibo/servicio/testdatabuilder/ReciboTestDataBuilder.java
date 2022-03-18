package com.ceiba.recibo.servicio.testdatabuilder;


import com.ceiba.recibo.modelo.entidad.Recibo;

import java.time.LocalDate;


public class ReciboTestDataBuilder {

    private Long id;
    private Long total;
    private Boolean entregaInmediata;
    private LocalDate fechaCompra;
    private String tipoObra;
    private Long idObra;

    public ReciboTestDataBuilder() {
        total = 3600000L;
        entregaInmediata = false;
        fechaCompra = LocalDate.now();
        tipoObra = "REALISMO";
        idObra = 1L;
    }

    public ReciboTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ReciboTestDataBuilder conTotal(Long total){
        this.total = total;
        return this;
    }

    public ReciboTestDataBuilder conEntregaInmediata(Boolean entregaInmediata) {
        this.entregaInmediata = entregaInmediata;
        return this;
    }

    public ReciboTestDataBuilder conFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
        return this;
    }

    public ReciboTestDataBuilder conTipoObra(String tipoObra) {
        this.tipoObra = tipoObra;
        return this;
    }

    public ReciboTestDataBuilder conIdObra(Long idObra) {
        this.idObra = idObra;
        return this;
    }

    public Recibo build() {
        return new Recibo(id, total, entregaInmediata, fechaCompra, tipoObra, idObra);
    }
}
