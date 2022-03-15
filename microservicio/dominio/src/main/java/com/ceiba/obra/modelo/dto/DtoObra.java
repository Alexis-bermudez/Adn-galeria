package com.ceiba.obra.modelo.dto;

import com.ceiba.obra.modelo.entidad.TipoObra;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoObra {
    private Long id;
    private String titulo;
    private TipoObra tipoObra;
    private Long precio;
    private Boolean vendido;

}
