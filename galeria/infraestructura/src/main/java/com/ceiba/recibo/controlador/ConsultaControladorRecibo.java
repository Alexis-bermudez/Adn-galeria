package com.ceiba.recibo.controlador;

import com.ceiba.recibo.consulta.ManejadorListarRecibo;
import com.ceiba.recibo.modelo.dto.DtoRecibo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recibos")
@Api(tags={"Controlador consulta recibos"})
public class ConsultaControladorRecibo {

    private final ManejadorListarRecibo manejadorListarRecibo;

    public ConsultaControladorRecibo(ManejadorListarRecibo manejadorListarRecibo) {
        this.manejadorListarRecibo = manejadorListarRecibo;
    }

    @GetMapping
    @ApiOperation("Listar Recibos")
    public List<DtoRecibo> listar() {
        return this.manejadorListarRecibo.ejecutar();
    }

}
