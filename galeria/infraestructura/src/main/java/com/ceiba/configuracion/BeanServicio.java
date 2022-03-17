package com.ceiba.configuracion;

import com.ceiba.obra.puerto.repositorio.RepositorioObra;
import com.ceiba.obra.servicio.ServicioActualizarObra;
import com.ceiba.obra.servicio.ServicioCrearObra;
import com.ceiba.obra.servicio.ServicioEliminarObra;
import com.ceiba.recibo.puerto.repositorio.RepositorioRecibo;
import com.ceiba.recibo.servicio.ServicioActualizarRecibo;
import com.ceiba.recibo.servicio.ServicioCrearRecibo;
import com.ceiba.recibo.servicio.ServicioEliminarRecibo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearObra servicioCrearObra(RepositorioObra repositorioObra) {
        return new ServicioCrearObra(repositorioObra);
    }

    @Bean
    public ServicioEliminarObra servicioEliminarObra(RepositorioObra repositorioObra) {
        return new ServicioEliminarObra(repositorioObra);
    }

    @Bean
    public ServicioActualizarObra servicioActualizarObra(RepositorioObra repositorioObra) {
        return new ServicioActualizarObra(repositorioObra);
    }

    @Bean
    public ServicioCrearRecibo servicioCrearRecibo(RepositorioRecibo repositorioRecibo) {
        return new ServicioCrearRecibo(repositorioRecibo);
    }

    @Bean
    public ServicioEliminarRecibo servicioEliminarRecibo(RepositorioRecibo repositorioRecibo) {
        return new ServicioEliminarRecibo(repositorioRecibo);
    }

    @Bean
    public ServicioActualizarRecibo servicioActualizarRecibo(RepositorioRecibo repositorioRecibo) {
        return new ServicioActualizarRecibo(repositorioRecibo);
    }

}
