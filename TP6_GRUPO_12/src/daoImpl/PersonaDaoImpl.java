package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.PersonaDao;
import entidad.Persona;

public class PersonaDaoImpl implements PersonaDao {
	///Consultas
	private static final String insert = "INSERT INTO personas(Dni, Nombre, Apellido) VALUES(?, ?, ?)";
	private static final String update = "UPDATE personas SET Nombre = ? , Apellido = ? WHERE Dni = ? ";
	private static final String delete = "DELETE FROM personas WHERE Dni = ?";
	private static final String readall = "SELECT * FROM personas";
	

	@Override
	public boolean AgregarPersona(Persona persona) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setString(1, persona.getDni());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getApellido());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return isInsertExitoso;
	}

	
	public boolean ModificarPersona(Persona persona_Modificada) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean UpdateExitoso = false;
		
		try
		{
			statement = conexion.prepareStatement(update);
			statement.setString(1, persona_Modificada.getNombre());
			statement.setString(2, persona_Modificada.getApellido());
			statement.setString(3, persona_Modificada.getDni());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				UpdateExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return UpdateExitoso;
	}

	
	public boolean EliminarPersona(Persona persona_Eliminada) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean PersonaBorrada = false;
		
		try {
			statement = conexion.prepareStatement(delete);
			statement.setString(1, persona_Eliminada.getDni());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				PersonaBorrada = true;
			}
		}catch (SQLException e) 
			{
				e.printStackTrace();
				try {
					conexion.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			return PersonaBorrada;
		}

	
	public ArrayList<Persona> readAll() {
		ArrayList <Persona> lPersonas = new ArrayList <Persona>();

		ResultSet rs;
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			rs = statement.executeQuery();
			while(rs.next()) {
			Persona x = new Persona();
			x.setNombre(rs.getString("Nombre"));
			x.setApellido(rs.getString("Apellido"));
			x.setDni(rs.getString("DNI"));
			lPersonas.add(x);
		}}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return lPersonas;

	
		}
}
