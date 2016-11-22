package vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Usuarios_agregar extends JFrame {
	private JLabel lbl_titulo;
	private JLabel lbl_foto;
	private JLabel lbl_nombres, lbl_apellidos, lbl_fecha_nacimiento, lbl_fecha_registro, lbl_contrasenha, lbl_foto1, lbl_tipo_usuario;
	private JTextField tf_nombres, tf_apellidos, tf_fecha_nacimiento, tf_fecha_registro;
	private JPasswordField pf_contrasenha;
	private JComboBox cb_tipo_usuario;
	private JButton btn_foto, btn_regresar, btn_agregar, btn_limpiar;
	private JFileChooser fc;
	
	
	public Usuarios_agregar() {
		super("Agregar usuarios");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		ImageIcon icon=new ImageIcon("geppeto_tienda.png");
		
		
		lbl_titulo=new JLabel();
		lbl_titulo.setBounds(90, 10, 500, 100);
		lbl_titulo.setIcon(icon);
		add(lbl_titulo);
		
		lbl_nombres=new JLabel("Nombre(s):");
		lbl_nombres.setBounds(250, 120, 100, 30);
		add(lbl_nombres);
		
		tf_nombres=new JTextField();
		tf_nombres.setBounds(360, 125, 200, 20);
		add(tf_nombres);
		
		lbl_apellidos=new JLabel("Apellidos(s):");
		lbl_apellidos.setBounds(250, 150, 100, 30);
		add(lbl_apellidos);
		
		tf_apellidos=new JTextField();
		tf_apellidos.setBounds(360, 155, 200, 20);
		add(tf_apellidos);
		
		lbl_fecha_nacimiento=new JLabel("Fecha de nacimiento:");
		lbl_fecha_nacimiento.setBounds(250, 180, 150, 30);
		add(lbl_fecha_nacimiento);
		
		tf_fecha_nacimiento=new JTextField();
		tf_fecha_nacimiento.setBounds(380, 185, 100, 20);
		add(tf_fecha_nacimiento);
		
		lbl_fecha_registro=new JLabel("Fecha de registro:");
		lbl_fecha_registro.setBounds(250, 210, 150, 30);
		add(lbl_fecha_registro);
		
		tf_fecha_registro=new JTextField();
		tf_fecha_registro.setBounds(380, 215, 100, 20);
		add(tf_fecha_registro);
		
		lbl_contrasenha=new JLabel("Contraseña:");
		lbl_contrasenha.setBounds(250, 240, 150, 30);
		add(lbl_contrasenha);
		
		pf_contrasenha=new JPasswordField();
		pf_contrasenha.setBounds(380, 245, 100, 20);
		add(pf_contrasenha);
		
		lbl_tipo_usuario=new JLabel("Tipo de usuario:");
		lbl_tipo_usuario.setBounds(250, 270, 150, 30);
		add(lbl_tipo_usuario);
		
		String[] tipo={"Administrador", "Operador", "Contador"};
		
		cb_tipo_usuario=new JComboBox(tipo);
		cb_tipo_usuario.setBounds(380, 275, 200, 20);
		add(cb_tipo_usuario);
		
		lbl_foto=new JLabel("foto");
		lbl_foto.setBounds(30, 120, 150, 150);
		add(lbl_foto);
		
		
		btn_foto=new JButton("buscar fotografía");
		btn_foto.setBounds(30, 280, 150, 30);
		add(btn_foto);
		
		btn_limpiar=new JButton("Limpiar");
		btn_limpiar.setBounds(30, 370, 100, 30);
		add(btn_limpiar);
		
		btn_agregar=new JButton("Agregar");
		btn_agregar.setBounds(150, 370, 100, 30);
		add(btn_agregar);
		
		btn_regresar=new JButton("Regresar");
		btn_regresar.setBounds(270, 370, 100, 30);
		add(btn_regresar);
		
	}


	public JComboBox getCb_tipo_usuario() {
		return cb_tipo_usuario;
	}


	public void setCb_tipo_usuario(JComboBox cb_tipo_usuario) {
		this.cb_tipo_usuario = cb_tipo_usuario;
	}


	public JButton getBtn_foto() {
		return btn_foto;
	}


	public void setBtn_foto(JButton btn_foto) {
		this.btn_foto = btn_foto;
	}


	public JButton getBtn_regresar() {
		return btn_regresar;
	}


	public void setBtn_regresar(JButton btn_regresar) {
		this.btn_regresar = btn_regresar;
	}


	public JButton getBtn_agregar() {
		return btn_agregar;
	}


	public void setBtn_agregar(JButton btn_agregar) {
		this.btn_agregar = btn_agregar;
	}


	public JButton getBtn_limpiar() {
		return btn_limpiar;
	}


	public void setBtn_limpiar(JButton btn_limpiar) {
		this.btn_limpiar = btn_limpiar;
	}


	public JTextField getTf_nombres() {
		return tf_nombres;
	}


	public void setTf_nombres(JTextField tf_nombres) {
		this.tf_nombres = tf_nombres;
	}


	public JTextField getTf_apellidos() {
		return tf_apellidos;
	}


	public void setTf_apellidos(JTextField tf_apellidos) {
		this.tf_apellidos = tf_apellidos;
	}


	public JTextField getTf_fecha_nacimiento() {
		return tf_fecha_nacimiento;
	}


	public void setTf_fecha_nacimiento(JTextField tf_fecha_nacimiento) {
		this.tf_fecha_nacimiento = tf_fecha_nacimiento;
	}


	public JTextField getTf_fecha_registro() {
		return tf_fecha_registro;
	}


	public void setTf_fecha_registro(JTextField tf_fecha_registro) {
		this.tf_fecha_registro = tf_fecha_registro;
	}


	public JPasswordField getPf_contrasenha() {
		return pf_contrasenha;
	}


	public void setPf_contrasenha(JPasswordField pf_contrasenha) {
		this.pf_contrasenha = pf_contrasenha;
	}


	public JLabel getLbl_foto() {
		return lbl_foto;
	}


	public void setLbl_foto(JLabel lbl_foto) {
		this.lbl_foto = lbl_foto;
	}
	
	
}
