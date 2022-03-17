package com.ceiba.obra.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Obra {

    private static final String SE_DEBE_INGRESAR_EL_TIPO_DE_OBRA = "Se debe ingresar el tipo de la obra";
    private static final String SE_DEBE_INGRESAR_EL_PRECIO = "Se debe ingresar el precio de la obra";
    private static final String SE_DEBE_INGRESAR_EL_TITULO_DE_LA_OBRA = "Se debe ingresar el titulo de la obra";
    private static final String SE_DEBE_INGRESAR_SI_FUE_VENDIDO = "Se debe ingresar si la obra fue vendida o no";

    private Long id;
    private String titulo;
    private String tipoObra;
    private Long precio;
    private Boolean vendido;

    public Obra(Long id, String titulo, String tipoObra, Long precio, Boolean vendido) {
        validarObligatorio(titulo, SE_DEBE_INGRESAR_EL_TITULO_DE_LA_OBRA);
        validarObligatorio(tipoObra, SE_DEBE_INGRESAR_EL_TIPO_DE_OBRA);
        validarObligatorio(precio, SE_DEBE_INGRESAR_EL_PRECIO);
        validarObligatorio(vendido, SE_DEBE_INGRESAR_SI_FUE_VENDIDO);

        this.id = id;
        this.titulo = titulo;
        this.tipoObra = tipoObra;
        this.precio = precio;
        this.vendido = vendido;
    }

}
