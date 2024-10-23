package negocioImpl;

import java.util.List;

import dao.PersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.PersonaNegocio;

public class PersonaNegocioImpl implements PersonaNegocio {

	PersonaDao pdao = new PersonaDaoImpl();
	@Override
	public boolean AgregarPersona(Persona persona) {
		boolean estado= pdao.AgregarPersona(persona);
		return estado;
	}

	@Override
	public boolean ModificarPersona(Persona persona_Modificada) {
		boolean estado=false;
		if(persona_Modificada.getNombre().trim().length()>0 && persona_Modificada.getApellido().trim().length()>0)
		{
			estado=pdao.ModificarPersona(persona_Modificada);
		}
		return estado;
	}

	@Override
	public boolean EliminarPersona(Persona persona_Eliminada) {
		boolean estado = false;
		estado=pdao.EliminarPersona(persona_Eliminada);
		return estado;
	}

	public List<Persona> readAll() {
		return pdao.readAll();
	}

}
