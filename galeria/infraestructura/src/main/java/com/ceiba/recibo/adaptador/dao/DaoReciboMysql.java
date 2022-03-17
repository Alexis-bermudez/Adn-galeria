package com.ceiba.recibo.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.recibo.modelo.dto.DtoRecibo;
import com.ceiba.recibo.puerto.dao.DaoRecibo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoReciboMysql implements DaoRecibo {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="recibo", value="listar")
    private static String sqlListar;

    public DaoReciboMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoRecibo> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoRecibo());
    }
}
