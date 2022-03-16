package com.ceiba.obra.servicio.testdatabuilder;

import com.ceiba.obra.modelo.entidad.TipoObra;
import com.ceiba.usuario.comando.ComandoObra;

import java.util.UUID;

public class ComandoObraTestDataBuilder {

    private Long id;
    private String titulo;
    private TipoObra tipoObra;
    private Long precio;
    private Boolean vendido;

    public ComandoObraTestDataBuilder() {
        titulo = UUID.randomUUID().toString();
        tipoObra = TipoObra.REALISMO;
        precio = 3600000L;
        vendido = false;
    }

    public ComandoObraTestDataBuilder conNombre(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public ComandoObra build() {
        return new ComandoObra(id, titulo, tipoObra, precio, vendido);
    }
}
