package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import modelo.Usuario;



public class Articulos_agregar extends JFrame {
	private JPanel contentPane;
	private JTextField tf_nombre;
	private JTextField tf_costo;
	private JTextField tf_existencia, tf_anho;
	private JComboBox cb_categoria;
	private JTextArea ta_descripcion;
	private JTextArea ta_historia;
	private JLabel lbl_foto;
	private JLabel lbl_bienvenido, lbl_nombres;
	private JButton btn_buscar, btn_agregar, btn_cancelar;
	private JFileChooser fc;
	
	
	public Articulos_agregar(Usuario usuario) {
		setTitle("Agregar articulo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(5, 5));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel.setVisible(true);
		
		ImageIcon icon1=new ImageIcon("geppeto_tienda.png");
		
		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setIcon(icon1);
		panel.add(lblNewLabel_2);
		
		lbl_bienvenido = new JLabel();
		panel.add(lbl_bienvenido);
		
		lbl_nombres = new JLabel();
		panel.add(lbl_nombres);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JLabel lbl_nombre = new JLabel("Nombre:");
		lbl_nombre.setBounds(38, 28, 72, 14);
		panel_2.add(lbl_nombre);
		
		tf_nombre = new JTextField();
		tf_nombre.setBounds(120, 25, 276, 20);
		panel_2.add(tf_nombre);
		tf_nombre.setColumns(10);
		
		JLabel lbl_costo = new JLabel("Costo:");
		lbl_costo.setBounds(38, 53, 72, 14);
		panel_2.add(lbl_costo);
		
		tf_costo = new JTextField();
		tf_costo.setBounds(119, 50, 66, 20);
		panel_2.add(tf_costo);
		tf_costo.setColumns(10);
		
		JLabel lbl_existencia = new JLabel("Existencia:");
		lbl_existencia.setBounds(37, 80, 72, 14);
		panel_2.add(lbl_existencia);
		
		tf_existencia = new JTextField();
		tf_existencia.setBounds(120, 77, 86, 20);
		panel_2.add(tf_existencia);
		tf_existencia.setColumns(10);
		
		JLabel lbl_anho = new JLabel("Año:");
		lbl_anho.setBounds(230, 80, 72, 14);
		panel_2.add(lbl_anho);

		tf_anho = new JTextField();
		tf_anho.setBounds(265, 77, 86, 20);
		panel_2.add(tf_anho);
		tf_anho.setColumns(10);
		
		JLabel lbl_categoria = new JLabel("Categoria:");
		lbl_categoria.setBounds(38, 105, 77, 14);
		panel_2.add(lbl_categoria);
		
		cb_categoria = new JComboBox();
		cb_categoria.setBounds(120, 108, 200, 20);
		panel_2.add(cb_categoria);
		
		JLabel lbl_imagen = new JLabel("Imagen:");
		lbl_imagen.setBounds(574, 28, 46, 14);
		panel_2.add(lbl_imagen);
		
		lbl_foto = new JLabel("New label");
		lbl_foto.setBounds(488, 53, 200, 200);
		panel_2.add(lbl_foto);
		
		btn_buscar = new JButton("Buscar");
		btn_buscar.setBounds(556, 279, 89, 23);
		panel_2.add(btn_buscar);
		
		JLabel lbl_descripcion = new JLabel("Descripci\u00F3n:");
		lbl_descripcion.setBounds(120, 160, 86, 14);
		panel_2.add(lbl_descripcion);
		
		ta_descripcion = new JTextArea();
		ta_descripcion.setBounds(38, 185, 376, 123);
		panel_2.add(ta_descripcion);
		
		JLabel lbl_historia = new JLabel("Historia:");
		lbl_historia.setBounds(120, 319, 72, 14);
		panel_2.add(lbl_historia);
		
		ta_historia = new JTextArea();
		ta_historia.setBounds(38, 347, 376, 123);
		panel_2.add(ta_historia);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.activeCaption);
		panel_3.setBounds(544, 331, 128, 99);
		panel_2.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btn_agregar = new JButton("Agregar");
		panel_3.add(btn_agregar);
		
		btn_cancelar = new JButton("Cancelar");
		panel_3.add(btn_cancelar);
		
		fc=new JFileChooser();
		FileNameExtensionFilter filter=new FileNameExtensionFilter("PNG, JPG & GIF", "png", "jpg", "gif");
		fc.setFileFilter(filter);
		
		setVisible(false);
	}


	public JTextField getTf_nombre() {
		return tf_nombre;
	}


	public void setTf_nombre(JTextField tf_nombre) {
		this.tf_nombre = tf_nombre;
	}


	public JTextField getTf_costo() {
		return tf_costo;
	}


	public void setTf_costo(JTextField tf_costo) {
		this.tf_costo = tf_costo;
	}


	public JTextField getTf_existencia() {
		return tf_existencia;
	}


	public void setTf_existencia(JTextField tf_existencia) {
		this.tf_existencia = tf_existencia;
	}


	public JComboBox getCb_categoria() {
		return cb_categoria;
	}


	public void setCb_categoria(JComboBox cb_categoria) {
		this.cb_categoria = cb_categoria;
	}


	public JTextArea getTa_descripcion() {
		return ta_descripcion;
	}


	public void setTa_descripcion(JTextArea ta_descripcion) {
		this.ta_descripcion = ta_descripcion;
	}


	public JTextArea getTa_historia() {
		return ta_historia;
	}


	public void setTa_historia(JTextArea ta_historia) {
		this.ta_historia = ta_historia;
	}


	public JLabel getLbl_foto() {
		return lbl_foto;
	}


	public void setLbl_foto(JLabel lbl_foto) {
		this.lbl_foto = lbl_foto;
	}


	public JLabel getLbl_bienvenido() {
		return lbl_bienvenido;
	}


	public void setLbl_bienvenido(JLabel lbl_bienvenido) {
		this.lbl_bienvenido = lbl_bienvenido;
	}


	public JLabel getLbl_nombres() {
		return lbl_nombres;
	}


	public void setLbl_nombres(JLabel lbl_nombres) {
		this.lbl_nombres = lbl_nombres;
	}


	public JButton getBtn_buscar() {
		return btn_buscar;
	}


	public void setBtn_buscar(JButton btn_buscar) {
		this.btn_buscar = btn_buscar;
	}


	public JButton getBtn_agregar() {
		return btn_agregar;
	}


	public void setBtn_agregar(JButton btn_agregar) {
		this.btn_agregar = btn_agregar;
	}


	public JButton getBtn_cancelar() {
		return btn_cancelar;
	}


	public void setBtn_cancelar(JButton btn_cancelar) {
		this.btn_cancelar = btn_cancelar;
	}


	public JFileChooser getFc() {
		return fc;
	}


	public void setFc(JFileChooser fc) {
		this.fc = fc;
	}


	public JTextField getTf_anho() {
		return tf_anho;
	}


	public void setTf_anho(JTextField tf_anho) {
		this.tf_anho = tf_anho;
	}
	
	
	
	
	
	
	
	
	
	


}
