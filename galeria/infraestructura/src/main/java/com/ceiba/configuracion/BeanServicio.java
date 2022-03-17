package com.ceiba.configuracion;

import com.ceiba.obra.puerto.repositorio.RepositorioObra;
import com.ceiba.obra.servicio.ServicioActualizarObra;
import com.ceiba.obra.servicio.ServicioCrearObra;
import com.ceiba.obra.servicio.ServicioEliminarObra;
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
	

}
