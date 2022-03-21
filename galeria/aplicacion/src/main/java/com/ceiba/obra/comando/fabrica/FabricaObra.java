package com.ceiba.obra.comando.fabrica;

import com.ceiba.obra.comando.ComandoObra;
import com.ceiba.obra.modelo.entidad.Obra;
import org.springframework.stereotype.Component;

@Component
public class FabricaObra {

    public Obra crear(ComandoObra comandoObra) {
        return new Obra(
                comandoObra.getId(),
                comandoObra.getTitulo(),
                comandoObra.getTipoObra().toString(),
                comandoObra.getPrecio(),
                comandoObra.getVendido()
        );
    }

}
