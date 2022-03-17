package com.ceiba.recibo.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.recibo.modelo.entidad.Recibo;
import com.ceiba.recibo.puerto.repositorio.RepositorioRecibo;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioReciboMysql implements RepositorioRecibo {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="recibo", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="recibo", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="recibo", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="recibo", value="existePorId")
    private static String sqlExistePorId;

    public RepositorioReciboMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Recibo recibo) { return this.customNamedParameterJdbcTemplate.crear(recibo, sqlCrear); }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public void actualizar(Recibo recibo) {
        this.customNamedParameterJdbcTemplate.actualizar(recibo, sqlActualizar);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);
    }
}
