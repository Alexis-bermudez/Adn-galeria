package com.ceiba.recibo.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.recibo.comando.ComandoRecibo;
import com.ceiba.recibo.comando.manejador.ManejadorActualizarRecibo;
import com.ceiba.recibo.comando.manejador.ManejadorCrearRecibo;
import com.ceiba.recibo.comando.manejador.ManejadorEliminarRecibo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recibos")
@Api(tags = { "Controlador comando recibos"})
public class ComandoControladorRecibo {

    private final ManejadorCrearRecibo manejadorCrearRecibo;
    private final ManejadorEliminarRecibo manejadorEliminarRecibo;
    private final ManejadorActualizarRecibo manejadorActualizarRecibo;

    @Autowired
    public ComandoControladorRecibo(ManejadorCrearRecibo manejadorCrearRecibo,
                                    ManejadorEliminarRecibo manejadorEliminarRecibo,
                                    ManejadorActualizarRecibo manejadorActualizarRecibo) {
        this.manejadorCrearRecibo = manejadorCrearRecibo;
        this.manejadorEliminarRecibo = manejadorEliminarRecibo;
        this.manejadorActualizarRecibo = manejadorActualizarRecibo;
    }

    @PostMapping
    @ApiOperation("Crear recibo")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoRecibo comandoRecibo) {
        return manejadorCrearRecibo.ejecutar(comandoRecibo);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar recibo")
    public void actualizar(@RequestBody ComandoRecibo comandoRecibo, @PathVariable Long id) {
        comandoRecibo.setId(id);
        manejadorActualizarRecibo.ejecutar(comandoRecibo);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar recibo")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarRecibo.ejecutar(id);
    }

}

