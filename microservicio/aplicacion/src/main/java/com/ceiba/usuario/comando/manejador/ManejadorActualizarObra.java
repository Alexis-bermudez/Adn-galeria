package com.ceiba.usuario.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.obra.modelo.entidad.Obra;
import com.ceiba.obra.servicio.ServicioActualizarObra;
import com.ceiba.usuario.comando.fabrica.FabricaObra;
import org.springframework.stereotype.Component;

import com.ceiba.usuario.comando.ComandoObra;

@Component
public class ManejadorActualizarObra implements ManejadorComando<ComandoObra> {

    private final FabricaObra fabricaObra;
    private final ServicioActualizarObra servicioActualizarObra;

    public ManejadorActualizarObra(FabricaObra fabricaObra, ServicioActualizarObra servicioActualizarObra) {
        this.fabricaObra = fabricaObra;
        this.servicioActualizarObra = servicioActualizarObra;
    }

    public void ejecutar(ComandoObra comandoObra) {
        Obra obra = this.fabricaObra.crear(comandoObra);
        this.servicioActualizarObra.ejecutar(obra);
    }
}
