package com.ceiba.obra.controlador;

import java.util.List;

import com.ceiba.obra.modelo.dto.DtoObra;
import com.ceiba.usuario.consulta.ManejadorListarObra;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/obras")
@Api(tags={"Controlador consulta obras"})
public class ConsultaControladorObra {

    private final ManejadorListarObra manejadorListarObra;

    public ConsultaControladorObra(ManejadorListarObra manejadorListarObra) {
        this.manejadorListarObra = manejadorListarObra;
    }

    @GetMapping
    @ApiOperation("Listar Obras")
    public List<DtoObra> listar() {
        return this.manejadorListarObra.ejecutar();
    }

}
