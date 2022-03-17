package com.ceiba.recibo.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.obra.servicio.ServicioEliminarObra;
import com.ceiba.recibo.servicio.ServicioEliminarRecibo;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarRecibo implements ManejadorComando<Long> {

    private final ServicioEliminarRecibo servicioEliminarRecibo;

    public ManejadorEliminarRecibo(ServicioEliminarRecibo servicioEliminarRecibo) {
        this.servicioEliminarRecibo = servicioEliminarRecibo;
    }

    public void ejecutar(Long idRecibo) {
        this.servicioEliminarRecibo.ejecutar(idRecibo);
    }
}
