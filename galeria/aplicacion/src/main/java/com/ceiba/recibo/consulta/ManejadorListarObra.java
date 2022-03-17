package com.ceiba.recibo.consulta;

import com.ceiba.obra.modelo.dto.DtoObra;
import com.ceiba.obra.puerto.dao.DaoObra;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarObra {

    private final DaoObra daoObra;

    public ManejadorListarObra(DaoObra daoObra){
        this.daoObra = daoObra;
    }

    public List<DtoObra> ejecutar(){ return this.daoObra.listar(); }
}
