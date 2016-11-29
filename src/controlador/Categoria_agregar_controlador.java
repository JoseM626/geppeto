package controlador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import modelo.Categoria;
import modelo.CategoriaDAO;
import modelo.Usuario;
import vista.Categoria_agregar;

public class Categoria_agregar_controlador implements ActionListener {
	private Categoria_agregar ventana;
	private Usuario usuario;
	private Categoria categoria;
	private File source;
	private CategoriaDAO categoria_dao;
	
	public Categoria_agregar_controlador(Usuario usuario) {
		this.usuario=usuario;
		ventana=new Categoria_agregar(this.usuario);
		categoria_dao=new CategoriaDAO();
		categoria=new Categoria();
		ventana.getBtn_buscar().addActionListener(this);
		ventana.getBtn_guardar().addActionListener(this);
		ventana.getBtn_cancelar().addActionListener(this);
		source=new File("usuario.png");
		
		ventana.setVisible(true);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==ventana.getBtn_buscar()) {
			int valor=ventana.getFc().showOpenDialog(ventana);
			if(valor==JFileChooser.APPROVE_OPTION) {
				String path=ventana.getFc().getSelectedFile().getPath();
				//System.out.println(path);
				ImageIcon imagen=new ImageIcon(path);
				Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
				//System.out.println("Width:"+icon.getIconWidth());
				//System.out.println("Height:"+icon.getIconHeight());
				ventana.getLbl_cat_foto().setIcon(icono);
				source=new File(path);
			}
			
		}
		if(arg0.getSource()==ventana.getBtn_guardar()) {
			if(!ventana.getTextField().getText().isEmpty()) {
				categoria.setNombre(ventana.getTextField().getText());
				if(ventana.getTextArea().getText().isEmpty()) {
					categoria.setDescripcion("Descripción no disponible");					
				}else {
					categoria.setDescripcion(ventana.getTextArea().getText());
				}
				categoria.setFoto(source);
				if(categoria_dao.agregar(categoria)) {
					System.out.println("Agregado");
					ventana.getTextArea().setEnabled(false);
					ventana.getTextField().setEnabled(false);
					ventana.getBtn_guardar().setEnabled(false);
				}else {
					System.out.println("imposible agregar");
				}
			}else {
				System.out.println("Ingresar un valor en nombre");
			}
			System.out.println(categoria);
		}
		if(arg0.getSource()==ventana.getBtn_cancelar()) {
			ventana.getTextField().setText("");
			ventana.getTextArea().setText("");
			source=new File("usuario.png");
			ImageIcon icon=new ImageIcon("usuario.png");
			ventana.getLbl_cat_foto().setIcon(icon);
		}
		
		
	}

}
