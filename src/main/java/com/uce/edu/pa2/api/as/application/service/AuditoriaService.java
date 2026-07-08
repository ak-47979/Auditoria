package com.uce.edu.pa2.api.as.application.service;



import com.uce.edu.pa2.api.as.domain.model.Auditoria;
import com.uce.edu.pa2.api.as.domain.repository.AuditoriaRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AuditoriaService {

    @Inject
    private AuditoriaRepository repository;

    public void guardar(Auditoria auditoria){
        this.repository.insertar(auditoria);
    }

}
