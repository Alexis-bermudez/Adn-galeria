package com.ceiba.obra.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.obra.modelo.dto.DtoObra;
import com.ceiba.obra.puerto.dao.DaoObra;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoObraMysql implements DaoObra {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="obra", value="listar")
    private static String sqlListar;

    public DaoObraMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoObra> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoObra());
    }
}
