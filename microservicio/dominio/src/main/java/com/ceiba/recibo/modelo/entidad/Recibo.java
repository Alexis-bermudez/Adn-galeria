package com.ceiba.recibo.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Recibo {

    private static final String SE_DEBE_INGRESAR_EL_TOTAL = "Se debe ingresar el total a pagar por la obra";
    private static final String SE_DEBE_INGRESAR_LA_ENTREGA_INMEDIATA = "Se debe ingresar si la entrega se realiza inmediatamente";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_COMPRA = "Se debe ingresar la fecha de compra";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_ENTREGA = "Se debe ingresar la fecha de entrega";
    private static final String SE_DEBE_INGRESAR_EL_ID_DE_LA_OBRA_VENDIDA = "Se debe ingresar el id de la obra vendida";

    private Long id;
    private Long total;
    private Boolean entregaInmediata;
    private LocalDateTime fechaCompra;
    private LocalDateTime fechaEntrega;
    private Long idObra;

    public Recibo(Long id, Long total, Boolean entregaInmediata, LocalDateTime fechaCompra, LocalDateTime fechaEntrega, Long idObra) {
        validarObligatorio(total, SE_DEBE_INGRESAR_EL_TOTAL);
        validarObligatorio(entregaInmediata, SE_DEBE_INGRESAR_LA_ENTREGA_INMEDIATA);
        validarObligatorio(fechaCompra, SE_DEBE_INGRESAR_LA_FECHA_DE_COMPRA);
        validarObligatorio(fechaEntrega, SE_DEBE_INGRESAR_LA_FECHA_DE_ENTREGA);
        validarObligatorio(idObra, SE_DEBE_INGRESAR_EL_ID_DE_LA_OBRA_VENDIDA);

        this.id = id;
        this.total = total;
        this.entregaInmediata = entregaInmediata;
        this.fechaCompra = fechaCompra;
        this.fechaEntrega = fechaEntrega;
        this.idObra = idObra;
    }

}