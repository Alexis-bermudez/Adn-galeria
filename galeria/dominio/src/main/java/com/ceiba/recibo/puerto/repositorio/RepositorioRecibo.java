package com.ceiba.recibo.puerto.repositorio;

import com.ceiba.recibo.modelo.entidad.Recibo;

public interface RepositorioRecibo {
    /**
     * Permite crear un recibo
     * @param recibo
     * @return el id generado
     */
    Long crear(Recibo recibo);

    /**
     * Permite actualizar un recibo
     * @param recibo
     */
    void actualizar(Recibo recibo);

    /**
     * Permite eliminar un recibo
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un recibo por id
     * @return si existe o no
     */
    boolean existePorId(Long id);
}
