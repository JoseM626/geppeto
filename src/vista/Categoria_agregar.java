package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import modelo.Usuario;



public class Categoria_agregar extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JFileChooser fc;
	private JTextArea textArea;
	private JButton btn_guardar, btn_cancelar, btn_buscar;
	private JLabel lbl_cat_foto;
	
	public Categoria_agregar(Usuario usuario) {
		setTitle("Categorias agregar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		ImageIcon icon1=new ImageIcon("geppeto_tienda.png");
		JLabel lbl_banner = new JLabel();
		lbl_banner.setIcon(icon1);
		contentPane.add(lbl_banner, BorderLayout.NORTH);
		
		JPanel pnl_usuario = new JPanel();
		contentPane.add(pnl_usuario, BorderLayout.SOUTH);
		
		JLabel lbl_foto = new JLabel();
		ImageIcon imagen=new ImageIcon(usuario.getImagen());
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		lbl_foto.setIcon(icono);
		pnl_usuario.add(lbl_foto);
		
		JLabel lbl_nombre = new JLabel("Bienvenido ");
		pnl_usuario.add(lbl_nombre);
		
		JLabel lbl_apellidos = new JLabel(usuario.getNombres()+" "+usuario.getApellidos());
		pnl_usuario.add(lbl_apellidos);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lbl_cat_nombre = new JLabel("Nombre:");
		lbl_cat_nombre.setBounds(10, 11, 66, 14);
		panel.add(lbl_cat_nombre);
		
		JLabel lbl_descripcion = new JLabel("Descripci\u00F3n:");
		lbl_descripcion.setBounds(10, 76, 116, 14);
		panel.add(lbl_descripcion);
		
		JLabel lbl_imagen = new JLabel("Imagen:");
		lbl_imagen.setBounds(547, 11, 46, 14);
		panel.add(lbl_imagen);
		
		ImageIcon icon=new ImageIcon("usuario.png");
		lbl_cat_foto = new JLabel();
		lbl_cat_foto.setBounds(547, 36, 200, 200);
		lbl_cat_foto.setIcon(icon);
		panel.add(lbl_cat_foto);
		
		textField = new JTextField();
		textField.setBounds(136, 8, 312, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setBounds(136, 71, 312, 157);
		panel.add(textArea);
		
		btn_buscar = new JButton("Buscar");
		btn_buscar.setBounds(547, 250, 89, 23);
		panel.add(btn_buscar);
		
		btn_guardar = new JButton("Guardar");
		btn_guardar.setBounds(10, 296, 89, 23);
		panel.add(btn_guardar);
		
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setBounds(108, 296, 89, 23);
		panel.add(btn_cancelar);
		
		fc=new JFileChooser();
		FileNameExtensionFilter filter=new FileNameExtensionFilter("PNG, JPG & GIF", "png", "jpg", "gif");
		fc.setFileFilter(filter);
		
		setVisible(false);

	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JFileChooser getFc() {
		return fc;
	}

	public void setFc(JFileChooser fc) {
		this.fc = fc;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public JButton getBtn_guardar() {
		return btn_guardar;
	}

	public void setBtn_guardar(JButton btn_guardar) {
		this.btn_guardar = btn_guardar;
	}

	public JButton getBtn_cancelar() {
		return btn_cancelar;
	}

	public void setBtn_cancelar(JButton btn_cancelar) {
		this.btn_cancelar = btn_cancelar;
	}

	public JButton getBtn_buscar() {
		return btn_buscar;
	}

	public void setBtn_buscar(JButton btn_buscar) {
		this.btn_buscar = btn_buscar;
	}

	public JLabel getLbl_cat_foto() {
		return lbl_cat_foto;
	}

	public void setLbl_cat_foto(JLabel lbl_cat_foto) {
		this.lbl_cat_foto = lbl_cat_foto;
	}
	
	
	



}
