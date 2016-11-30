package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Usuario;
import vista.Principal;

public class Principal_controlador implements ActionListener {
	private Principal principal;
	private Categoria_agregar_controlador categoria_agregar_controlador;
	private Articulos_agregar_controlador articulos_agregar_controlador;
	private Usuario usuario;
	
	public Principal_controlador(Usuario usuario) {
		this.usuario=usuario;
		principal=new Principal(usuario);
		principal.getJmi_articulos_agregar().addActionListener(this);
		principal.getJmi_articulos_reporte().addActionListener(this);
		principal.getJmi_categorias_agregar().addActionListener(this);
		principal.getJmi_categorias_reporte().addActionListener(this);
		principal.getJmi_clientes_reporte().addActionListener(this);
		principal.getJmi_salir_salir().addActionListener(this);
		principal.getJmi_ventas_diario().addActionListener(this);
		principal.getJmi_ventas_mensual().addActionListener(this);
		principal.setVisible(true);		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==principal.getJmi_salir_salir()) {
			System.exit(0);
			
		}
		if(arg0.getSource()==principal.getJmi_categorias_agregar()) {
			categoria_agregar_controlador=new Categoria_agregar_controlador(this.usuario);
		}
		if(arg0.getSource()==principal.getJmi_articulos_agregar()) {
			articulos_agregar_controlador=new Articulos_agregar_controlador(this.usuario);
		}
	}

	

}
