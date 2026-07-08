package com.uce.edu.pa2.api.as.infraestructure.repository;


import com.uce.edu.pa2.api.as.domain.model.Estudiante;
import com.uce.edu.pa2.api.as.domain.repository.EstudianteRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class EstudianteRepositoryImpl implements EstudianteRepository {


    //la clase emtityManagerhace es el principal que gestiona e implementa ORM gestionar todos los accesos de datos (CRUD)
    @Inject
    private EntityManager em;

    //persist es guardar en la base de datos,
    @Override

    public void crear(Estudiante estudiante) {
        this.em.persist(estudiante);
    }

    //debe tener un dato primaria en la base de datos para el uso del merge
    @Override
    
    public void actualizar(Estudiante estudiante) {
        this.em.merge(estudiante);

    }

    //para el metodo eliminar usamos el metodo seleccionar por id
    @Override
  
    public void eliminar(Integer id) {
        this.em.remove(this.seleccionarPorId(id));
    }

    @Override

    public Estudiante seleccionarPorId(Integer id) {
        return this.em.find(Estudiante.class, id);
    }

}