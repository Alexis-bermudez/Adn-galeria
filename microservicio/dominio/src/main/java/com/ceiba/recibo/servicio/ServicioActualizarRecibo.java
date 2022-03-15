package com.ceiba.recibo.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.recibo.modelo.entidad.Recibo;
import com.ceiba.recibo.puerto.repositorio.RepositorioRecibo;

public class ServicioActualizarRecibo {

    private static final String EL_RECIBO_NO_EXISTE_EN_EL_SISTEMA = "El recibo no existe en el sistema";

    private final RepositorioRecibo repositorioRecibo;

    public ServicioActualizarRecibo(RepositorioRecibo repositorioRecibo) {
        this.repositorioRecibo = repositorioRecibo;
    }

    public void ejecutar(Recibo recibo) {
        validarExistenciaPrevia(recibo);
        this.repositorioRecibo.actualizar(recibo);
    }

    private void validarExistenciaPrevia(Recibo recibo) {
        boolean existe = this.repositorioRecibo.existePorId(recibo.getId());
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_RECIBO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
