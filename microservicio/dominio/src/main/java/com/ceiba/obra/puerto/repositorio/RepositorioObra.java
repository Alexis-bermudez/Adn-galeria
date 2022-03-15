package com.ceiba.obra.puerto.repositorio;

import com.ceiba.obra.modelo.entidad.Obra;

public interface RepositorioObra {
    /**
     * Permite crear una obra
     * @param obra
     * @return el id generado
     */
    Long crear(Obra obra);

    /**
     * Permite actualizar una obra
     * @param obra
     */
    void actualizar(Obra obra);

    /**
     * Permite eliminar una obra
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe una obra por titulo
     * @param titulo
     * @return si existe o no
     */
    boolean existe(String titulo);

    /**
     * Permite validar si existe una obra por id
     * @return si existe o no
     */
    boolean existePorId(Long id);

}
