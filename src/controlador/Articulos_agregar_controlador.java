package controlador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import modelo.Articulo;
import modelo.ArticuloDAO;
import modelo.Categoria;
import modelo.CategoriaDAO;
import modelo.Usuario;
import vista.Articulos_agregar;

public class Articulos_agregar_controlador implements ActionListener {
	private Articulos_agregar ventana;
	private Articulo articulo;
	private Usuario usuario;
	private File source;
	private CategoriaDAO categoria_dao;
	private ArticuloDAO articulo_dao;
	private Categoria categoria;
	
	public Articulos_agregar_controlador(Usuario usuario) {
		this.usuario=usuario;
		ventana=new Articulos_agregar(this.usuario);
		categoria=new Categoria();
		articulo=new Articulo();
		
		source=new File("articulos.png");
		categoria_dao=new CategoriaDAO();
		articulo_dao=new ArticuloDAO();
		
		ImageIcon imagen=new ImageIcon("articulos.png");
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		ventana.getLbl_foto().setIcon(icono);
		
		ImageIcon imagen1=new ImageIcon(usuario.getImagen());
		Icon icono1 = new ImageIcon(imagen1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		ventana.getLbl_bienvenido().setIcon(icono1);
		
		ventana.getLbl_nombres().setText("Bienvenido "+usuario.getNombres()+" "+usuario.getApellidos());
		
		final DefaultComboBoxModel model = new DefaultComboBoxModel(categoria_dao.traer());
	    		
		ventana.getCb_categoria().setModel(model);
		
		ventana.getBtn_buscar().addActionListener(this);
		ventana.getBtn_agregar().addActionListener(this);
		ventana.getBtn_cancelar().addActionListener(this);
		
		
		
		ventana.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==ventana.getBtn_buscar()) {
			int valor=ventana.getFc().showOpenDialog(ventana);
			if(valor==JFileChooser.APPROVE_OPTION) {
				String path=ventana.getFc().getSelectedFile().getPath();
				//System.out.println(path);
				ImageIcon imagen=new ImageIcon(path);
				Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
				//System.out.println("Width:"+icon.getIconWidth());
				//System.out.println("Height:"+icon.getIconHeight());
				ventana.getLbl_foto().setIcon(icono);
				source=new File(path);
			}
			
		}
		if(arg0.getSource()==ventana.getBtn_agregar()) {
			if(ventana.getTf_nombre().getText().isEmpty() && ventana.getTf_costo().getText().isEmpty() && ventana.getTf_existencia().getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Favor de complementar todos los datos", "Alerta", 0);
			}else {
				articulo.setNombre(ventana.getTf_nombre().getText());
				articulo.setDescripcion(ventana.getTa_descripcion().getText());
				articulo.setCosto(Double.parseDouble(ventana.getTf_costo().getText()));
				articulo.setExistencia(Integer.parseInt(ventana.getTf_existencia().getText()));
				articulo.setHistoria(ventana.getTa_historia().getText());
				articulo.setId_categoria(categoria_dao.traer_id(ventana.getCb_categoria().getSelectedItem().toString()));
				articulo.setFoto(source);
				articulo.setAnho(Integer.parseInt(ventana.getTf_anho().getText()));
				System.out.println(articulo.toString());
				
				if(articulo_dao.agregar(articulo)) {
					JOptionPane.showMessageDialog(null, "Los datos fueron guardados", "Operación exitosa", 1);
					ventana.getBtn_agregar().setEnabled(false);
					ventana.getBtn_buscar().setEnabled(false);
				}
				
			}
			
		}
		if(arg0.getSource()==ventana.getBtn_cancelar()) {
			ventana.getTf_nombre().setText("");
			ventana.getTa_descripcion().setText("");
			ventana.getTf_costo().setText("");
			ventana.getTf_existencia().setText("");
			ventana.getTa_historia().setText("");
			ventana.getTf_anho().setText("");
			source=new File("articulos.png");
			ImageIcon icon=new ImageIcon("articulos.png");
			ventana.getLbl_foto().setIcon(icon);
		}
		
	}
	

}
