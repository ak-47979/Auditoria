package com.uce.edu.pa2.api.as.infraestructure.repository;



import com.uce.edu.pa2.api.as.domain.model.Auditoria;
import com.uce.edu.pa2.api.as.domain.repository.AuditoriaRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class AuditoriaRepositoryImpl implements AuditoriaRepository {

    @Inject
    private EntityManager em;

    
    @Override
    public void insertar(Auditoria auditoria){
        em.persist(auditoria);
    }

}