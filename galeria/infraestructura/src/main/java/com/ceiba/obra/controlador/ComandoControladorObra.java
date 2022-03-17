package com.ceiba.obra.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.obra.comando.ComandoObra;
import com.ceiba.obra.comando.manejador.ManejadorActualizarObra;
import com.ceiba.obra.comando.manejador.ManejadorCrearObra;
import com.ceiba.obra.comando.manejador.ManejadorEliminarObra;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/obras")
@Api(tags = { "Controlador comando obras"})
public class ComandoControladorObra {

    private final ManejadorCrearObra manejadorCrearObra;
	private final ManejadorEliminarObra manejadorEliminarObra;
	private final ManejadorActualizarObra manejadorActualizarObra;

    @Autowired
    public ComandoControladorObra(ManejadorCrearObra manejadorCrearObra,
								  ManejadorEliminarObra manejadorEliminarObra,
								  ManejadorActualizarObra manejadorActualizarObra) {
        this.manejadorCrearObra = manejadorCrearObra;
		this.manejadorEliminarObra = manejadorEliminarObra;
		this.manejadorActualizarObra = manejadorActualizarObra;
    }

    @PostMapping
    @ApiOperation("Crear obra")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoObra comandoObra) {
        return manejadorCrearObra.ejecutar(comandoObra);
    }

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar obra")
	public void actualizar(@RequestBody ComandoObra comandoObra, @PathVariable Long id) {
		comandoObra.setId(id);
		manejadorActualizarObra.ejecutar(comandoObra);
	}

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar obra")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarObra.ejecutar(id);
	}

}
