package controlador;

import modelo.Usuario;
import vista.Principal;

public class Principal_controlador {
	private Principal principal;
	
	public Principal_controlador(Usuario usuario) {
		principal=new Principal(usuario);
		principal.setVisible(true);
		
		
		
		
	}

	

}
