package com.ceiba.obra.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.obra.modelo.entidad.Obra;
import com.ceiba.obra.puerto.repositorio.RepositorioObra;

public class ServicioActualizarObra {

    private static final String LA_OBRA_NO_EXISTE_EN_EL_SISTEMA = "La obra no existe en el sistema";

    private final RepositorioObra repositorioObra;

    public ServicioActualizarObra(RepositorioObra repositorioObra) {
        this.repositorioObra = repositorioObra;
    }

    public void ejecutar(Obra obra) {
        validarExistenciaPrevia(obra);
        this.repositorioObra.actualizar(obra);
    }

    private void validarExistenciaPrevia(Obra obra) {
        boolean existe = this.repositorioObra.existePorId(obra.getId());
        if(!existe) {
            throw new ExcepcionDuplicidad(LA_OBRA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
