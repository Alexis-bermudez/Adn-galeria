package com.ceiba.usuario.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.obra.servicio.ServicioEliminarObra;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarObra implements ManejadorComando<Long> {

    private final ServicioEliminarObra servicioEliminarObra;

    public ManejadorEliminarObra(ServicioEliminarObra servicioEliminarObra) {
        this.servicioEliminarObra = servicioEliminarObra;
    }

    public void ejecutar(Long idObra) {
        this.servicioEliminarObra.ejecutar(idObra);
    }
}
