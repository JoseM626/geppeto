package vista;

import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import modelo.Usuario;

public class Principal extends JFrame {
	private JMenuBar jmb;
	private JMenu jm_clientes, jm_articulos, jm_categorias, jm_ventas, jm_salir;
	private JMenuItem jmi_clientes_reporte, jmi_articulos_agregar, jmi_articulos_reporte, jmi_categorias_agregar, jmi_categorias_reporte, jmi_ventas_diario, jmi_ventas_mensual;
	private JMenuItem jmi_salir_salir;
	private JLabel lbl_foto, lbl_nombres, lbl_bienvenido, lbl_titulo;
	
	public Principal(Usuario usuario) {
		super("Menu principal");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		System.out.println(usuario.toString());
		switch(usuario.getTipo_usuario()) {
		case 0:
			inicializar_administrador(usuario);
			break;
		case 1:
			break;
		case 2:
			inicializar_administrador(usuario);
			inicializar_contador(usuario);
			break;
		}
		
		
		ImageIcon icon1=new ImageIcon("geppeto_tienda.png");
		
		
		lbl_titulo=new JLabel();
		lbl_titulo.setBounds(100, 200, 500, 120);
		lbl_titulo.setIcon(icon1);
		add(lbl_titulo);
		
		lbl_foto=new JLabel();
		lbl_foto.setBounds(500, 10, 50, 50);
		ImageIcon imagen=new ImageIcon(usuario.getImagen());
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lbl_foto.getWidth(), lbl_foto.getHeight(), Image.SCALE_DEFAULT));
		lbl_foto.setIcon(icono);
		
		add(lbl_foto);
		
		lbl_bienvenido=new JLabel("Bienvenido");
		lbl_bienvenido.setBounds(570, 10, 300, 30);
		add(lbl_bienvenido);
		
		lbl_nombres=new JLabel(usuario.getNombres()+" "+usuario.getApellidos());
		lbl_nombres.setBounds(570, 30, 300, 30);
		add(lbl_nombres);
				
	}
	private void inicializar_administrador(Usuario usuario) {
		
		jmb=new JMenuBar();
		
		jm_clientes=new JMenu("Clientes");
		jmi_clientes_reporte=new JMenuItem("Reporte");
		jm_clientes.add(jmi_clientes_reporte);
		
		jm_articulos=new JMenu("Articulos");
		jmi_articulos_agregar=new JMenuItem("Agregar");
		jmi_articulos_reporte=new JMenuItem("Reporte");
		jm_articulos.add(jmi_articulos_agregar);
		jm_articulos.add(jmi_articulos_reporte);
		
		jm_categorias=new JMenu("Categorias");
		jmi_categorias_agregar=new JMenuItem("Agregar");
		jmi_categorias_reporte=new JMenuItem("Reporte");
		jm_categorias.add(jmi_categorias_agregar);
		jm_categorias.add(jmi_categorias_reporte);
		
		jm_ventas=new JMenu("Ventas");
		jmi_ventas_diario=new JMenuItem("Reporte diario");
		jmi_ventas_mensual=new JMenuItem("Reporte mensual");
		jm_ventas.add(jmi_ventas_diario);
		jm_ventas.add(jmi_ventas_mensual);
		
		jm_salir=new JMenu("Salir");
		jmi_salir_salir=new JMenuItem("Salir");
		jm_salir.add(jmi_salir_salir);
		
		jmb.add(jm_clientes);
		jmb.add(jm_articulos);
		jmb.add(jm_categorias);
		jmb.add(jm_ventas);
		jmb.add(jm_salir);		
		
		setJMenuBar(jmb);
		
	}
	private void inicializar_contador(Usuario usuario) {
		jmi_articulos_agregar.setVisible(false);
		jmi_categorias_agregar.setVisible(false);		
	}
	public JMenuItem getJmi_clientes_reporte() {
		return jmi_clientes_reporte;
	}
	public JMenuItem getJmi_articulos_agregar() {
		return jmi_articulos_agregar;
	}
	public JMenuItem getJmi_articulos_reporte() {
		return jmi_articulos_reporte;
	}
	public JMenuItem getJmi_categorias_agregar() {
		return jmi_categorias_agregar;
	}
	public JMenuItem getJmi_categorias_reporte() {
		return jmi_categorias_reporte;
	}
	public JMenuItem getJmi_ventas_diario() {
		return jmi_ventas_diario;
	}
	public JMenuItem getJmi_ventas_mensual() {
		return jmi_ventas_mensual;
	}
	public JMenuItem getJmi_salir_salir() {
		return jmi_salir_salir;
	}
	

}
