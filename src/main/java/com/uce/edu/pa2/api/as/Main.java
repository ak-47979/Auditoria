package com.uce.edu.pa2.api.as;

import java.time.LocalDate;

import com.uce.edu.pa2.api.as.application.service.EstudianteService;

import com.uce.edu.pa2.api.as.domain.model.Estudiante;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main {

    public static void main(String[] args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {
        @Inject
        private EstudianteService estudianteService;
  
        @Override
        public int run(String... args) throws Exception {
            System.out.println("conexion exitosa");
            Estudiante e = new Estudiante();
            e.setNombre("Andy");
            e.setApellido("Suquilandi");
            e.setGenero("M");
            e.setFechaNacimiento(LocalDate.now());
            this.estudianteService.guardar(e);
            
            return 0;
        }
    
        
    }
}
