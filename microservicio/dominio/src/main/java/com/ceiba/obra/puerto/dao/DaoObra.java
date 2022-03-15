package com.ceiba.obra.puerto.dao;

import com.ceiba.obra.modelo.dto.DtoObra;

import java.util.List;

public interface DaoObra {

    /**
     * Permite listar obras
     * @return las obras
     */
    List<DtoObra> listar();
}
