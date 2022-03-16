package com.ceiba.usuario.comando;

import com.ceiba.obra.modelo.entidad.TipoObra;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoObra {

    private Long id;
    private String titulo;
    private TipoObra tipoObra;
    private Long precio;
    private Boolean vendido;
}
