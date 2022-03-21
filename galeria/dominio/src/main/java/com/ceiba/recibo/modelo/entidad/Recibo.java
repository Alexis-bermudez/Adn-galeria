package com.ceiba.recibo.modelo.entidad;

import lombok.Getter;

import java.time.LocalDate;
import java.util.HashMap;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Recibo {

    private static final String SE_DEBE_INGRESAR_EL_TOTAL = "Se debe ingresar el total a pagar por la obra";
    private static final String SE_DEBE_INGRESAR_LA_ENTREGA_INMEDIATA = "Se debe ingresar si la entrega se realiza inmediatamente";
    private static final String NO_SE_PUEDE_VENDER_LOS_DIAS_SABADOS = "No se puede vender los días sábados";
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
        validarObligatorio(tipoObra, SE_DEBE_INGRESAR_EL_TIPO_DE_OBRA);
        validarTipoObra(tipoObra, TIPO_DE_OBRA_NO_ADMITIDO);
        validarObligatorio(idObra, SE_DEBE_INGRESAR_EL_ID_DE_LA_OBRA_VENDIDA);
        if (fechaCompra == null) {
            fechaCompra = LocalDate.now();
        }
        validarQueNoSeaSabado(fechaCompra, NO_SE_PUEDE_VENDER_LOS_DIAS_SABADOS);

        this.id = id;
        this.total = setTotal(entregaInmediata, total, tipoObra);
        this.fechaEntrega = setFechaEntrega(entregaInmediata, fechaCompra, tipoObra);
        this.entregaInmediata = entregaInmediata;
        this.fechaCompra = fechaCompra;
        this.tipoObra = tipoObra;
        this.idObra = idObra;
    }

    private Long setTotal(Boolean entregaInmediata, Long total, String tipoObra) {
        HashMap<String, Double> cobroExtra = new HashMap<>();
        cobroExtra.put("REALISMO", 1.1);
        cobroExtra.put("SURREALISMO", 1.07);
        cobroExtra.put("ABSTRACTO", 1.05);

        if (!entregaInmediata) {
            return total;
        }
        return (long)(total*(cobroExtra.get(tipoObra)));
    }

    private LocalDate setFechaEntrega(Boolean entregaInmediata, LocalDate fechaCompra, String tipoObra) {
        HashMap<String, Integer> cobroExtra = new HashMap<>();
        cobroExtra.put("REALISMO", 15);
        cobroExtra.put("SURREALISMO", 10);
        cobroExtra.put("ABSTRACTO", 7);

        if (entregaInmediata) {
            return fechaCompra;
        }
        return fechaCompra.plusDays(cobroExtra.get(tipoObra));
    }

}