package com.ceiba.recibo.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.recibo.comando.ComandoRecibo;
import com.ceiba.recibo.comando.fabrica.FabricaRecibo;
import com.ceiba.recibo.modelo.entidad.Recibo;
import com.ceiba.recibo.servicio.ServicioCrearRecibo;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearRecibo implements ManejadorComandoRespuesta<ComandoRecibo, ComandoRespuesta<Long>> {

    private final FabricaRecibo fabricaRecibo;
    private final ServicioCrearRecibo servicioCrearRecibo;

    public ManejadorCrearRecibo(FabricaRecibo fabricaRecibo, ServicioCrearRecibo servicioCrearRecibo) {
        this.fabricaRecibo = fabricaRecibo;
        this.servicioCrearRecibo = servicioCrearRecibo;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoRecibo comandoRecibo) {
        Recibo recibo = this.fabricaRecibo.crear(comandoRecibo);
        return new ComandoRespuesta<>(this.servicioCrearRecibo.ejecutar(recibo));
    }
}
