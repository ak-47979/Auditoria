package uce.edu.ec.domain.repository;

import uce.edu.ec.domain.model.Estudiante;



//Se crea una por cada entidad, es decir, una por cada clase que representa una tabla en la base de datos
public interface EstudianteRepository {
    //implemento los metodos que voy a necesitar para realizar EL CRUD
    public void crear(Estudiante estudiante);
    public Estudiante seleccionarPorId(Integer id);
    public void actualizar(Estudiante estudiante);
    public void eliminar(Integer id);
   
    
}
