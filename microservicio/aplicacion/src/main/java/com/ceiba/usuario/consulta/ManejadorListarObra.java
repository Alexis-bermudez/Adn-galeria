package com.ceiba.usuario.consulta;

import java.util.List;

import com.ceiba.obra.modelo.dto.DtoObra;
import com.ceiba.obra.puerto.dao.DaoObra;
import com.ceiba.usuario.puerto.dao.DaoUsuario;
import org.springframework.stereotype.Component;

import com.ceiba.usuario.modelo.dto.DtoUsuario;

@Component
public class ManejadorListarObra {

    private final DaoObra daoObra;

    public ManejadorListarObra(DaoObra daoObra){
        this.daoObra = daoObra;
    }

    public List<DtoObra> ejecutar(){ return this.daoObra.listar(); }
}
