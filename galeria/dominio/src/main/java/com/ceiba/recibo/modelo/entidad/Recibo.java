package com.ceiba.recibo.modelo.entidad;

import lombok.Getter;

import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Recibo {

    private static final String SE_DEBE_INGRESAR_EL_TOTAL = "Se debe ingresar el total a pagar por la obra";
    private static final String SE_DEBE_INGRESAR_LA_ENTREGA_INMEDIATA = "Se debe ingresar si la entrega se realiza inmediatamente";
    private static final String NO_SE_PUEDE_VENDER_LOS_DIAS_SABADOS = "No se puede vender los días sábados";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_ENTREGA = "Se debe ingresar la fecha de entrega";
    private static final String SE_DEBE_INGRESAR_EL_TIPO_DE_OBRA = "Se debe ingresar el tipo de obra";
    private static final String TIPO_DE_OBRA_NO_ADMITIDO = "Tipo de obra no admitido";
    private static final String SE_DEBE_INGRESAR_EL_ID_DE_LA_OBRA_VENDIDA = "Se debe ingresar el id de la obra vendida";

    private Long id;
    private Long total;
    private Boolean entregaInmediata;
    private LocalDate fechaCompra;
    private LocalDate fechaEntrega;
    private String tipoObra;
    private Long idObra;

    public Recibo(Long id, Long total, Boolean entregaInmediata, LocalDate fechaCompra, String tipoObra, Long idObra) {
        validarObligatorio(total, SE_DEBE_INGRESAR_EL_TOTAL);
        validarObligatorio(entregaInmediata, SE_DEBE_INGRESAR_LA_ENTREGA_INMEDIATA);
        validarQueNoSeaSabado(fechaCompra, NO_SE_PUEDE_VENDER_LOS_DIAS_SABADOS);
        validarObligatorio(tipoObra, SE_DEBE_INGRESAR_EL_TIPO_DE_OBRA);
        validarTipoObra(tipoObra, TIPO_DE_OBRA_NO_ADMITIDO);
        validarObligatorio(idObra, SE_DEBE_INGRESAR_EL_ID_DE_LA_OBRA_VENDIDA);

        this.id = id;
        validarFechaEntrega(entregaInmediata, fechaCompra);
        this.entregaInmediata = entregaInmediata;
        this.total = (long)(total*validarCostoExtra(entregaInmediata, tipoObra));
        this.fechaCompra = fechaCompra == null ? LocalDate.now() : fechaCompra;
        this.tipoObra = tipoObra;
        this.idObra = idObra;
    }

    private void validarFechaEntrega(Boolean entregaInmediata, LocalDate fechaCompra) {
        if(entregaInmediata.booleanValue()){
            this.fechaEntrega = fechaCompra;
        }
    }

    private double validarCostoExtra(Boolean entregaInmediata, String tipoObra) {
        if(entregaInmediata.booleanValue()){
            if ("REALISMO".equals(tipoObra)){
                return 1.10;
            } else if ("SURREALISTA".equals(tipoObra)) {
                return 1.07;
            } else {
                return 1.05;
            }
        } else {
            return 1;
        }
    }

}