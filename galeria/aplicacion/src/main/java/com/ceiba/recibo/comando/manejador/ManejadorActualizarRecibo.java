package com.ceiba.recibo.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.recibo.comando.ComandoRecibo;
import com.ceiba.recibo.comando.fabrica.FabricaRecibo;
import com.ceiba.recibo.modelo.entidad.Recibo;
import com.ceiba.recibo.servicio.ServicioActualizarRecibo;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarRecibo implements ManejadorComando<ComandoRecibo> {

    private final FabricaRecibo fabricaRecibo;
    private final ServicioActualizarRecibo servicioActualizarRecibo;

    public ManejadorActualizarRecibo(FabricaRecibo fabricarRecibo, ServicioActualizarRecibo servicioActualizarRecibo) {
        this.fabricaRecibo = fabricarRecibo;
        this.servicioActualizarRecibo = servicioActualizarRecibo;
    }

    public void ejecutar(ComandoRecibo comandoObra) {
        Recibo recibo = this.fabricaRecibo.crear(comandoObra);
        this.servicioActualizarRecibo.ejecutar(recibo);
    }
}
