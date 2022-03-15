package com.ceiba.recibo.puerto.dao;

import com.ceiba.recibo.modelo.dto.DtoRecibo;

import java.util.List;

public interface DaoRecibo {

    /**
     * Permite listar recibos
     * @return los recibos
     */
    List<DtoRecibo> listar();
}
