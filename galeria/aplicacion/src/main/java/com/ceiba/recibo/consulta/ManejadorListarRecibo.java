package com.ceiba.recibo.consulta;

import com.ceiba.recibo.modelo.dto.DtoRecibo;
import com.ceiba.recibo.puerto.dao.DaoRecibo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarRecibo {

    private final DaoRecibo daoRecibo;

    public ManejadorListarRecibo(DaoRecibo daoRecibo){
        this.daoRecibo = daoRecibo;
    }

    public List<DtoRecibo> ejecutar(){ return this.daoRecibo.listar(); }
}
