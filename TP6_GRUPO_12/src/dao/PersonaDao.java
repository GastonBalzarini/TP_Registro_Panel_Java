package dao;

import java.util.List;

import entidad.Persona;

public interface PersonaDao {

	public boolean AgregarPersona(Persona persona);
	public boolean ModificarPersona(Persona persona_Modificada);
	public boolean EliminarPersona(Persona persona_Eliminada);
	public List<Persona> readAll(); 
}
