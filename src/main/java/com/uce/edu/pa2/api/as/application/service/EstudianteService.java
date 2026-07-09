package com.uce.edu.pa2.api.as.application.service;


import com.uce.edu.pa2.api.as.domain.model.Estudiante;
import com.uce.edu.pa2.api.as.domain.repository.EstudianteRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

//Aqui programamos toda la logica de negocio 
@ApplicationScoped
public class EstudianteService {

    @Inject

    private EstudianteRepository estudianteRepository;
    @MedirTiempo
    @Archivo
    public void guardar(Estudiante estudiante){
        this.estudianteRepository.crear(estudiante);

    }
    @MedirTiempo
    public void eliminar(Integer id){
        this.estudianteRepository.eliminar(id);;

    }
    @MedirTiempo
    public Estudiante buscarPorId(Integer id){
        return this.estudianteRepository.seleccionarPorId(id);

    }
    @MedirTiempo
    public void actualizar(Estudiante estudiante){
        this.estudianteRepository.actualizar(estudiante);

    }
}