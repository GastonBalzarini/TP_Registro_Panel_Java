package presentacion.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import presentacion.controlador.ControladorVentanaPrincipal;

//import TP5.Principal;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JMenuItem mntmAgregar;
	private JMenuItem mntmModificar;
	private JMenuItem mntmEliminar;
	private JMenuItem mntmListar;

	////gets y sets
	public JMenuItem getMntmAgregar() {
		return mntmAgregar;
	}


	public void setMntmAgregar(JMenuItem mntmAgregar) {
		this.mntmAgregar = mntmAgregar;
	}


	public JMenuItem getMntmModificar() {
		return mntmModificar;
	}


	public void setMntmModificar(JMenuItem mntmModificar) {
		this.mntmModificar = mntmModificar;
	}


	public JMenuItem getMntmEliminar() {
		return mntmEliminar;
	}


	public void setMntmEliminar(JMenuItem mntmEliminar) {
		this.mntmEliminar = mntmEliminar;
	}


	public JMenuItem getMntmListar() {
		return mntmListar;
	}


	public void setMntmListar(JMenuItem mntmListar) {
		this.mntmListar = mntmListar;
	}


	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setTitle("Programa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Persona");
		menuBar.add(mnNewMenu);
		
		mntmAgregar = new JMenuItem("Agregar");
		mnNewMenu.add(mntmAgregar);
		
		mntmModificar = new JMenuItem("Modificar");
		mnNewMenu.add(mntmModificar);
		
		mntmEliminar = new JMenuItem("Eliminar");
		mnNewMenu.add(mntmEliminar);
		
		mntmListar = new JMenuItem("Listar");
		mnNewMenu.add(mntmListar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
	}

	
	
	
	
}
