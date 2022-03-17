package com.ceiba.obra.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.obra.comando.ComandoObra;
import com.ceiba.obra.comando.fabrica.FabricaObra;
import com.ceiba.obra.modelo.entidad.Obra;
import com.ceiba.obra.servicio.ServicioCrearObra;
import org.springframework.stereotype.Component;

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
