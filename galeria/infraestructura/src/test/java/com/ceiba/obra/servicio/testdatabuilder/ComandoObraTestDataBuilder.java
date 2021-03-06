package com.ceiba.obra.servicio.testdatabuilder;

import com.ceiba.obra.comando.ComandoObra;
import com.ceiba.obra.modelo.dto.TipoObra;
import org.apache.commons.lang3.RandomStringUtils;

public class ComandoObraTestDataBuilder {

    private Long id;
    private String titulo;
    private TipoObra tipoObra;
    private Long precio;
    private Boolean vendido;

    public ComandoObraTestDataBuilder() {
        titulo = RandomStringUtils.randomAlphabetic(10);
        tipoObra = TipoObra.REALISMO;
        precio = Long.parseLong(RandomStringUtils.randomNumeric(8));
        vendido = false;
    }

    public ComandoObraTestDataBuilder conTituloTipoObraPrecioVendido(String titulo, TipoObra tipoObra,Long precio, Boolean vendido) {
        this.titulo = titulo;
        this.tipoObra = tipoObra;
        this.precio = precio;
        this.vendido = vendido;
        return this;
    }

    public ComandoObra build() {
        return new ComandoObra(id, titulo, tipoObra, precio, vendido);
    }
}
