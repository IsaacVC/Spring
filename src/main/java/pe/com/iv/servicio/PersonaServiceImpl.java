
package pe.com.iv.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.iv.dao.PersonaDao;
import pe.com.iv.domain.Persona;

//Anotacion para que Spring reconozca como service
@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    private PersonaDao personaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Persona> listaPersona() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        return personaDao.findById(persona.getId()).orElse(null);
    }
    
}
