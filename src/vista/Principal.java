package vista;

import javax.swing.JFrame;

import modelo.Usuario;

public class Principal extends JFrame {
	
	
	public Principal(Usuario usuario) {
		super("Menu principal");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
