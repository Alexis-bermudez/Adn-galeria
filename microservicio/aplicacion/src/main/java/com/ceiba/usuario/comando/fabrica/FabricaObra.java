package com.ceiba.usuario.comando.fabrica;

import com.ceiba.obra.modelo.entidad.Obra;
import org.springframework.stereotype.Component;

import com.ceiba.usuario.comando.ComandoObra;

@Component
public class FabricaObra {

    public Obra crear(ComandoObra comandoObra) {
        return new Obra(
                comandoObra.getId(),
                comandoObra.getTitulo(),
                comandoObra.getTipoObra(),
                comandoObra.getPrecio(),
                comandoObra.getVendido()
        );
    }

}
