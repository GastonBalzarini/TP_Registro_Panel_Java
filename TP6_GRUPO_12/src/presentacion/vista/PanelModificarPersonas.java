package presentacion.vista;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JList;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import entidad.Persona;
import negocio.PersonaNegocio;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class PanelModificarPersonas extends JPanel {
	private JTextField txtModNombre;
	private JTextField txtModApellido;
	private JTextField txtDNI;
	private JList<Persona> listModificarPersonas;
	private DefaultListModel<Persona> dlModel;
	private JButton btnModificar;
	
	
	public PanelModificarPersonas() {
		mostrarPanelModificar();
	}
	
	
	
	public JButton getBtnModificar() {
		return btnModificar;
	}



	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}



	public JTextField getTxtModNombre() {
		return txtModNombre;
	}


	public void setTxtModNombre(JTextField txtModNombre) {
		this.txtModNombre = txtModNombre;
	}


	public JTextField getTxtModApellido() {
		return txtModApellido;
	}


	public void setTxtModApellido(JTextField txtModApellido) {
		this.txtModApellido = txtModApellido;
	}


	public JTextField getTxtDNI() {
		return txtDNI;
	}


	public void setTxtDNI(JTextField txtDNI) {
		this.txtDNI = txtDNI;
	}


	public JList<Persona> getListModificarPersonas() {
		return listModificarPersonas;
	}


	public void setListModificarPersonas(JList<Persona> listModificarPersonas) {
		this.listModificarPersonas = listModificarPersonas;
	}


	public DefaultListModel<Persona> getDlModel() {
		return dlModel;
	}


	public void setDlModel(DefaultListModel<Persona> dlModel) {
		this.dlModel = dlModel;
	}



	public void mostrarPanelModificar()
	{
		setLayout(null);
		
		dlModel = new DefaultListModel<Persona>();
		listModificarPersonas = new JList<>(dlModel);
	    listModificarPersonas.setBounds(83, 52, 411, 192);
	    add(listModificarPersonas);
		
		JLabel lblSeleccioneLaPersona = new JLabel("Seleccione la persona que desea modificar");
		lblSeleccioneLaPersona.setBounds(83, 26, 421, 20);
		add(lblSeleccioneLaPersona);
		
		txtModNombre = new JTextField();
		txtModNombre.setBounds(26, 276, 125, 26);
		add(txtModNombre);
		txtModNombre.setColumns(10);
		
		txtModApellido = new JTextField();
		txtModApellido.setBounds(166, 276, 125, 26);
		add(txtModApellido);
		txtModApellido.setColumns(10);
		
		txtDNI = new JTextField();
		txtDNI.setEditable(false);
		txtDNI.setBounds(306, 276, 125, 26);
		add(txtDNI);
		txtDNI.setColumns(10);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(446, 275, 115, 29);
		add(btnModificar);
		
		
	}
	
	
	
	public void llenarTabla(ArrayList<Persona> personasEnTabla) {
		
		this.getDlModel().clear();
		
		

		for (Persona p : personasEnTabla)
		{
			this.getDlModel().addElement(p);
			
		}
		
	}


	
	
}
