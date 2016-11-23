package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.Login;

public class Login_controlador implements ActionListener {
	private Login ventana;
	private UsuarioDAO usuario_dao;
	private Usuario usuario;
	private Principal_controlador principal_controlador;
	
	public Login_controlador() {
		ventana=new Login();
		ventana.getBtn_aceptar().addActionListener(this);
		usuario_dao=new UsuarioDAO();
		usuario=new Usuario();
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Login_controlador login_controlador=new Login_controlador();
		login_controlador.ventana.setVisible(true);
		

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==ventana.getBtn_aceptar()) {
			String contra=String.copyValueOf(ventana.getPf_contrasenha().getPassword());
			usuario=usuario_dao.logear(ventana.getTf_nombres().getText(), contra);
			if(usuario.getId_usuario()!=0) {
				principal_controlador=new Principal_controlador(usuario);
				ventana.setVisible(false);
				//System.out.println(usuario);
			}else {
				ventana.getPf_contrasenha().setText("");
				ventana.getTf_nombres().setText("");
				ventana.getLbl_mensaje().setText("Datos incorrectos");
			}
			
		}
		
	}

}
