package com.ceiba.recibo.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.recibo.modelo.dto.DtoRecibo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoRecibo implements RowMapper<DtoRecibo>, MapperResult {

    @Override
    public DtoRecibo mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long total = resultSet.getLong("total");
        Boolean entregaInmediata = resultSet.getBoolean("entrega_inmediata");
        LocalDate fechaCompra = resultSet.getDate("fecha_compra").toLocalDate();
        LocalDate fechaEntrega = resultSet.getDate("fecha_entrega").toLocalDate();
        String tipoObra = resultSet.getString("tipo_obra");
        Long idObra = resultSet.getLong("id_obra");


        return new DtoRecibo(id, total, entregaInmediata, fechaCompra, fechaEntrega, tipoObra, idObra);
    }

}