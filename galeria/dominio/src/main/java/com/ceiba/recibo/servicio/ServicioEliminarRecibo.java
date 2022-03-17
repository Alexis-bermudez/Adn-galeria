package com.ceiba.recibo.servicio;

import com.ceiba.recibo.puerto.repositorio.RepositorioRecibo;

public class ServicioEliminarRecibo {
    private final RepositorioRecibo repositorioRecibo;

    public ServicioEliminarRecibo(RepositorioRecibo repositorioRecibo) {
        this.repositorioRecibo = repositorioRecibo;
    }

    public void ejecutar(Long id) {
        this.repositorioRecibo.eliminar(id);
    }
}
