package uce.edu.ec.application.service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.ec.domain.model.Auditoria;
import uce.edu.ec.domain.repository.AuditoriaRepository;

@ApplicationScoped
public class AuditoriaService {

    @Inject
    private AuditoriaRepository repository;

    public void guardar(Auditoria auditoria){
        this.repository.insertar(auditoria);
    }

}
