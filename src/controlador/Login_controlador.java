package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.Login;

public class Login_controlador implements ActionListener {
	private Login ventana;
	
	public Login_controlador() {
		ventana=new Login();
		ventana.getBtn_aceptar().addActionListener(this);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Login_controlador login_controlador=new Login_controlador();
		login_controlador.ventana.setVisible(true);
		

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
