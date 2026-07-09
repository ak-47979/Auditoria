package uce.edu.ec.infraestructure.repository;





import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Auditoria;
import uce.edu.ec.domain.repository.AuditoriaRepository;

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