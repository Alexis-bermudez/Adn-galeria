package com.ceiba.obra.controlador;

import com.ceiba.obra.consulta.ManejadorListarObra;
import com.ceiba.obra.modelo.dto.DtoObra;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
