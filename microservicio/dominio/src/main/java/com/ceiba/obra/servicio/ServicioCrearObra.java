package com.ceiba.obra.servicio;

import com.ceiba.obra.modelo.entidad.Obra;
import com.ceiba.obra.puerto.repositorio.RepositorioObra;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;


public class ServicioCrearObra {

    private static final String LA_OBRA_YA_EXISTE_EN_EL_SISTEMA = "La obra ya existe en el sistema";

    private final RepositorioObra repositorioObra;

    public ServicioCrearObra(RepositorioObra repositorioObra) {
        this.repositorioObra = repositorioObra;
    }

    public Long ejecutar(Obra obra) {
        validarExistenciaPrevia(obra);
        return this.repositorioObra.crear(obra);
    }

    private void validarExistenciaPrevia(Obra obra) {
        boolean existe = this.repositorioObra.existe(obra.getTitulo());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_OBRA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
