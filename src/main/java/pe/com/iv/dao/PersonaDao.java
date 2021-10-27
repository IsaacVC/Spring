package pe.com.iv.dao;

import org.springframework.data.repository.CrudRepository;
import pe.com.iv.domain.Persona;


public interface PersonaDao extends CrudRepository<Persona, Integer>{
    
}
