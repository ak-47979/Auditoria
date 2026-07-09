package uce.edu.ec;

import java.time.LocalDate;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import uce.edu.ec.application.service.AuditoriaService;
import uce.edu.ec.application.service.EstudianteService;
import uce.edu.ec.domain.model.Estudiante;

@QuarkusMain
public class Main {

    public static void main(String[] args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {
        @Inject
        private EstudianteService estudianteService;

        @Inject
        private AuditoriaService auditoriaService;
  
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
