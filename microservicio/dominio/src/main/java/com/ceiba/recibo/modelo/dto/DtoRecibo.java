package com.ceiba.recibo.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoRecibo {
    private Long id;
    private Long total;
    private Boolean entregaInmediata;
    private LocalDateTime fechaCompra;
    private LocalDateTime fechaEntrega;
    private Long idObra;
}
