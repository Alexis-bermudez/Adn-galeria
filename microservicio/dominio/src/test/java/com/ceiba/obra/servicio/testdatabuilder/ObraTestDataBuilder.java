package com.ceiba.obra.servicio.testdatabuilder;

import com.ceiba.obra.modelo.entidad.Obra;
import com.ceiba.obra.modelo.entidad.TipoObra;

import java.time.LocalDateTime;

public class ObraTestDataBuilder {

    private Long id;
    private String titulo;
    private TipoObra tipoObra;
    private Long precio;
    private Boolean vendido;

    public ObraTestDataBuilder() {
        titulo = "La Gioconda";
        tipoObra = TipoObra.REALISMO;
        precio = 3400000L;
        vendido = false;
    }

    public ObraTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ObraTestDataBuilder conTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public ObraTestDataBuilder conTipoObra(TipoObra tipoObra) {
        this.tipoObra = tipoObra;
        return this;
    }

    public ObraTestDataBuilder conPrecio(Long precio) {
        this.precio = precio;
        return this;
    }

    public ObraTestDataBuilder conVendido(boolean vendido) {
        this.vendido = vendido;
        return this;
    }

    public Obra build() {
        return new Obra(id, titulo, tipoObra, precio, vendido);
    }
}
