package com.ceiba.recibo.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.recibo.modelo.entidad.Recibo;
import com.ceiba.recibo.puerto.repositorio.RepositorioRecibo;

public class ServicioCrearRecibo {

    private static final String EL_RECIBO_YA_EXISTE_EN_EL_SISTEMA = "El recibo ya existe en el sistema";

    private final RepositorioRecibo repositorioRecibo;

    public ServicioCrearRecibo(RepositorioRecibo repositorioRecibo) {
        this.repositorioRecibo = repositorioRecibo;
    }

    public Long ejecutar(Recibo recibo) {
        validarExistenciaPrevia(recibo);
        return this.repositorioRecibo.crear(recibo);
    }

    private void validarExistenciaPrevia(Recibo recibo) {
        boolean existe = this.repositorioRecibo.existePorId(recibo.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_RECIBO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
