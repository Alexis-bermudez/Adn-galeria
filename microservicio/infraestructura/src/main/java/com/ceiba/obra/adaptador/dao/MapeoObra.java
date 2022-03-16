package com.ceiba.obra.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.obra.modelo.dto.DtoObra;
import com.ceiba.obra.modelo.entidad.TipoObra;
import org.springframework.jdbc.core.RowMapper;

public class MapeoObra implements RowMapper<DtoObra>, MapperResult {

    @Override
    public DtoObra mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String titulo = resultSet.getString("titulo");
        TipoObra tipoObra = resultSet.getObject("tipoObra", TipoObra.class);
        Long precio = resultSet.getLong("precio");
        Boolean vendido = resultSet.getBoolean("vendido");


        return new DtoObra(id, titulo, tipoObra, precio, vendido);
    }

}
