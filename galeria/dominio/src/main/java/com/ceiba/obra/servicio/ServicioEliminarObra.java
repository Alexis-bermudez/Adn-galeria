package com.ceiba.obra.servicio;

import com.ceiba.obra.puerto.repositorio.RepositorioObra;

public class ServicioEliminarObra {

    private final RepositorioObra repositorioObra;

    public ServicioEliminarObra(RepositorioObra repositorioObra) {
        this.repositorioObra = repositorioObra;
    }

    public void ejecutar(Long id) {
        this.repositorioObra.eliminar(id);
    }
}
