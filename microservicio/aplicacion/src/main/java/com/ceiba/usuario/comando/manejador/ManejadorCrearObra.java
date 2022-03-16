package com.ceiba.usuario.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.obra.modelo.entidad.Obra;
import com.ceiba.obra.servicio.ServicioCrearObra;
import com.ceiba.usuario.comando.fabrica.FabricaObra;
import org.springframework.stereotype.Component;

import com.ceiba.usuario.comando.ComandoObra;

@Component
public class ManejadorCrearObra implements ManejadorComandoRespuesta<ComandoObra, ComandoRespuesta<Long>> {

    private final FabricaObra fabricaObra;
    private final ServicioCrearObra servicioCrearObra;

    public ManejadorCrearObra(FabricaObra fabricaObra, ServicioCrearObra servicioCrearObra) {
        this.fabricaObra = fabricaObra;
        this.servicioCrearObra = servicioCrearObra;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoObra comandoObra) {
        Obra obra = this.fabricaObra.crear(comandoObra);
        return new ComandoRespuesta<>(this.servicioCrearObra.ejecutar(obra));
    }
}
