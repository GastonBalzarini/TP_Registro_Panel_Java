package main;

import java.awt.EventQueue;
import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
import presentacion.controlador.ControladorVentanaPrincipal;
import presentacion.vista.VentanaPrincipal;

public class Principal {

	public static void main(String[] args) {
		VentanaPrincipal vista = new VentanaPrincipal();
		PersonaNegocio negocio = new PersonaNegocioImpl();
		ControladorVentanaPrincipal controlador = new ControladorVentanaPrincipal(vista, negocio);
		controlador.inicializar();

	}

}