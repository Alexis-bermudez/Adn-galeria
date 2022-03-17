package com.ceiba.recibo.comando.fabrica;

import com.ceiba.recibo.comando.ComandoRecibo;
import com.ceiba.recibo.modelo.entidad.Recibo;
import org.springframework.stereotype.Component;

@Component
public class FabricaRecibo {

    public Recibo crear(ComandoRecibo comandoRecibo) {
        return new Recibo(
                comandoRecibo.getId(),
                comandoRecibo.getTotal(),
                comandoRecibo.getEntregaInmediata(),
                comandoRecibo.getFechaCompra(),
                comandoRecibo.getTipoObra(),
                comandoRecibo.getIdObra()
        );
    }

}
