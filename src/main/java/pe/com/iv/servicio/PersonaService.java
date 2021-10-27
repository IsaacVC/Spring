package pe.com.iv.servicio;

import java.util.List;
import pe.com.iv.domain.Persona;

public interface PersonaService {

    //Métodos
    public List<Persona> listaPersona();

    public void guardar(Persona persona);

    public void eliminar(Persona persona);

    public Persona encontrarPersona(Persona persona);

}
