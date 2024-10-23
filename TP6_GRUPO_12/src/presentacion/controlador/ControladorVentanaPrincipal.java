package presentacion.controlador;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;

import dao.PersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelEliminarUsuarios;
import presentacion.vista.PanelModificarPersonas;
import presentacion.vista.VentanaAgregarPersonas;
import presentacion.vista.VentanaPrincipal;

	


public class ControladorVentanaPrincipal implements ActionListener{
	private PersonaNegocio pNeg;
	private VentanaAgregarPersonas panelAgregar;
	private VentanaPrincipal ventanaPrincipal;
	private PanelModificarPersonas panelModPersonas;
	private PanelEliminarUsuarios panelElimUsuarios;
	private ArrayList<Persona> personasEnTabla;
	
	
	public ControladorVentanaPrincipal(VentanaPrincipal vista,PersonaNegocio pNeg) {
		this.ventanaPrincipal = vista;
		this.pNeg = pNeg;
		
		
		//Instancio los paneles
		this.panelAgregar = new VentanaAgregarPersonas();
		this.panelModPersonas = new PanelModificarPersonas();
		this.panelElimUsuarios = new PanelEliminarUsuarios();
		
		//Eventos menu del Frame principal llamado VentanaPrincipal
		this.ventanaPrincipal.getMntmAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
		this.ventanaPrincipal.getMntmModificar().addActionListener(m->MostrarpanelModificarPersona(m));
		this.ventanaPrincipal.getMntmEliminar().addActionListener(x -> MostrarPanelEliminarUsuarios(x));
		
		//Eventos PanelAgregarPersonas
		this.panelAgregar.getBtnAceptar().addActionListener(a->AgregarPersona(a));
		//Eventos PanelModificar
		this.panelModPersonas.getListModificarPersonas().addListSelectionListener(l->SeleccionarPersona(l));
		this.panelModPersonas.getBtnModificar().addActionListener(e->ModificarPersona(e));
		//Eventos PanelEliminar
		//this.panelElimUsuarios.getBtnEliminar().addActionListener(x -> EliminarPersona(x));
		this.panelElimUsuarios.getBtnEliminar().addActionListener(l -> EliminarPersona(l));
	}



	///se muestran los paneles
	private void EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a) {
		this.ventanaPrincipal.getContentPane().removeAll();
		this.ventanaPrincipal.getContentPane().add(this.panelAgregar);
		this.ventanaPrincipal.getContentPane().repaint();
		this.ventanaPrincipal.getContentPane().revalidate();
	}


	private void MostrarpanelModificarPersona(ActionEvent m) {
		this.ventanaPrincipal.getContentPane().removeAll();
		refrescarTabla();
		this.ventanaPrincipal.getContentPane().add(panelModPersonas);
		this.ventanaPrincipal.getContentPane().repaint();
		this.ventanaPrincipal.getContentPane().revalidate();
	}
	
	private void MostrarPanelEliminarUsuarios(ActionEvent x) {
	    this.ventanaPrincipal.getContentPane().removeAll();
	    refrescarTabla();
		this.panelElimUsuarios.llenarTabla(this.personasEnTabla);
	    this.ventanaPrincipal.getContentPane().add(panelElimUsuarios);
	    this.ventanaPrincipal.getContentPane().repaint();
	    this.ventanaPrincipal.getContentPane().revalidate();
	}

	
	///Desarrollo de los eventos del panelAgregarPersonas
	private void AgregarPersona(ActionEvent a) {
		if(panelAgregar.getTxtNombre().getText().isEmpty() == false && panelAgregar.getTxtApellido().getText().isEmpty() == false &&  panelAgregar.getTxtDni().getText().isEmpty() == false ) {
			Persona NuevaPersona = new Persona();
			NuevaPersona.setNombre(panelAgregar.getTxtNombre().getText());
			NuevaPersona.setApellido(panelAgregar.getTxtApellido().getText());
			NuevaPersona.setDni(panelAgregar.getTxtDni().getText());
			boolean resultado = pNeg.AgregarPersona(NuevaPersona);
			if(resultado == true) {
				JOptionPane.showMessageDialog(null, "Usuario agregado con exito");
				this.panelAgregar.getTxtNombre().setText("");
				this.panelAgregar.getTxtApellido().setText("");
				this.panelAgregar.getTxtDni().setText("");
			}
			else {
				JOptionPane.showMessageDialog(null, "No se pudo agregar el usuario");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Es necesario completar todos los campos");			
		}
	
		refrescarTabla();
	}
	
	///Desarrollo de los eventos del panelModificarPersonas
	private void SeleccionarPersona(ListSelectionEvent l) {
		if (!l.getValueIsAdjusting()) {
	        Persona personaSeleccionada = this.panelModPersonas.getListModificarPersonas().getSelectedValue();
	        if(personaSeleccionada!=null) {
	        this.panelModPersonas.getTxtDNI().setText(personaSeleccionada.getDni());
	        this.panelModPersonas.getTxtModNombre().setText(personaSeleccionada.getNombre());
	        this.panelModPersonas.getTxtModApellido().setText(personaSeleccionada.getApellido());
	        this.panelModPersonas.getTxtDNI().setEnabled(false);
	        }
	    }
	}
	
	private void ModificarPersona(ActionEvent e) {
		///arreglar
		String nombre = this.panelModPersonas.getTxtModNombre().getText();
		String apellido = this.panelModPersonas.getTxtModApellido().getText();
		String Dni = this.panelModPersonas.getTxtDNI().getText();
		Persona ModificarPersona = new Persona(Dni,nombre,apellido);
		
		boolean estado = pNeg.ModificarPersona(ModificarPersona);
		if(estado==true)
		{
			this.panelModPersonas.getTxtModNombre().setText("");
			this.panelModPersonas.getTxtModApellido().setText("");
			this.panelModPersonas.getTxtDNI().setText("");
			///this.panelModPersonas.getTxtDNI().setEnabled(true);
		}
		else {
			JOptionPane.showMessageDialog(null, "Es necesario completar todos los campos");
		}
		
		this.actualizarPanel();
		
	}
	
	private void EliminarPersona(ActionEvent s) {
		
		String nombre = this.panelModPersonas.getTxtModNombre().getText();
		String apellido = this.panelModPersonas.getTxtModApellido().getText();
		String Dni = this.panelModPersonas.getTxtDNI().getText();
		Persona EliminarPersona = new Persona(Dni,nombre,apellido);
		
		boolean estado = pNeg.EliminarPersona(EliminarPersona);
		if(estado==true)
		{
			JOptionPane.showMessageDialog(null, "Persona eliminada con exito");

		}
		else {
			JOptionPane.showMessageDialog(null, "Es necesario completar todos los campos");
		}
		
		this.actualizarPanel();
		
	}

	
	
	
	
	public void actionPerformed(ActionEvent e) {
		
	}
	public void inicializar()
	{
		this.ventanaPrincipal.setVisible(true);;
	}
	
	private void refrescarTabla()
	{
		this.personasEnTabla = (ArrayList<Persona>) pNeg.readAll();
		this.panelModPersonas.llenarTabla(this.personasEnTabla);
	}
	
	public void actualizarPanel() {
	    // Actualiza los datos del panel
	    this.refrescarTabla();
	    this.panelModPersonas.getListModificarPersonas().clearSelection();

	    // Revalida y redibuja el panel
	    this.panelModPersonas.revalidate(); 
	    this.panelModPersonas.repaint();    
	}
	
	
}
