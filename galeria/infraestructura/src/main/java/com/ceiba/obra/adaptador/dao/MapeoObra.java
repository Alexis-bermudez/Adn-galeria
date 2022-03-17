package com.ceiba.obra.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.obra.modelo.dto.DtoObra;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoObra implements RowMapper<DtoObra>, MapperResult {

    @Override
    public DtoObra mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String titulo = resultSet.getString("titulo");
        String tipoObra = resultSet.getString("tipo_obra");
        Long precio = resultSet.getLong("precio");
        Boolean vendido = resultSet.getBoolean("vendido");


        return new DtoObra(id, titulo, tipoObra, precio, vendido);
    }

}
