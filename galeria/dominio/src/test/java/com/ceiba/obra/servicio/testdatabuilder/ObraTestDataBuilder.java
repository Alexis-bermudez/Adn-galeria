package com.ceiba.obra.servicio.testdatabuilder;

import com.ceiba.obra.modelo.dto.TipoObra;
import com.ceiba.obra.modelo.entidad.Obra;

public class ObraTestDataBuilder {

    private Long id;
    private String titulo;
    private String tipoObra;
    private Long precio;
    private Boolean vendido;

    public ObraTestDataBuilder() {
        titulo = "La Gioconda";
        tipoObra = TipoObra.REALISMO.toString();
        precio = 3600000L;
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

    public ObraTestDataBuilder conTipoObra(String tipoObra) {
        this.tipoObra = tipoObra;
        return this;
    }

    public ObraTestDataBuilder conPrecio(Long precio) {
        this.precio = precio;
        return this;
    }

    public ObraTestDataBuilder conVendido(Boolean vendido) {
        this.vendido = vendido;
        return this;
    }

    public Obra build() {
        return new Obra(id, titulo, tipoObra, precio, vendido);
    }
}
