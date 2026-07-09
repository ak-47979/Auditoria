package uce.edu.ec.application.service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.ec.domain.model.Estudiante;
import uce.edu.ec.domain.repository.EstudianteRepository;

//Aqui programamos toda la logica de negocio 
@ApplicationScoped
public class EstudianteService {

    @Inject

    private EstudianteRepository estudianteRepository;
    @Auditar
    
    public void guardar(Estudiante estudiante){
        this.estudianteRepository.crear(estudiante);

    }
    @Auditar
    public void eliminar(Integer id){
        this.estudianteRepository.eliminar(id);;

    }
    @Auditar
    public Estudiante buscarPorId(Integer id){
        return this.estudianteRepository.seleccionarPorId(id);

    }
    @Auditar
    public void actualizar(Estudiante estudiante){
        this.estudianteRepository.actualizar(estudiante);

    }
}