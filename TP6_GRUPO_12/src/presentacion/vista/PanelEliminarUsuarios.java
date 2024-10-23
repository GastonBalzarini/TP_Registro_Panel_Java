package presentacion.vista;

import javax.swing.JPanel;

import entidad.Persona;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;



public class PanelEliminarUsuarios extends JPanel {
	
	private JButton btnEliminar;
	private JLabel lblEliminarUsuarios;
	private JList<Persona> listEliminarPersonas;
	private DefaultListModel<Persona> dlModel;
	
	public PanelEliminarUsuarios() {
		mostrarPanelEliminar();
	}
	
	
	public JButton getBtnEliminar() {
		return btnEliminar;
	}


	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}


	public JLabel getLblEliminarUsuarios() {
		return lblEliminarUsuarios;
	}


	public void setLblEliminarUsuarios(JLabel lblEliminarUsuarios) {
		this.lblEliminarUsuarios = lblEliminarUsuarios;
	}


	public JList<Persona> getListEliminarPersonas() {
		return listEliminarPersonas;
	}


	public void setListEliminarPersonas(JList<Persona> listEliminarPersonas) {
		this.listEliminarPersonas = listEliminarPersonas;
	}


	public DefaultListModel<Persona> getDlModel() {
		return dlModel;
	}


	public void setDlModel(DefaultListModel<Persona> dlModel) {
		this.dlModel = dlModel;
	}


	public void mostrarPanelEliminar() {
		setLayout(null);		
		btnEliminar = new JButton("Eliminar");

		dlModel = new DefaultListModel<Persona>();
		listEliminarPersonas = new JList<>(dlModel);
		listEliminarPersonas.setBounds(132, 68, 230, 154);
		add(listEliminarPersonas);
		
		JLabel lblEliminarUsuarios = new JLabel("Eliminar usuarios");
		lblEliminarUsuarios.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEliminarUsuarios.setBounds(122, 43, 106, 14);
		add(lblEliminarUsuarios);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBounds(142, 233, 220, 23);
		add(btnEliminar);

		
		
	}
	
	
	
	
	
	public void llenarTabla(ArrayList<Persona> personasEnTabla) {
		
		this.getDlModel().clear();
		
		for (Persona p : personasEnTabla) {
			
			this.getDlModel().addElement(p);
		}
		
		
	}
	
	
	
	
	
	
}
