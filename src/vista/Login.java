package vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {
	private JLabel lbl_titulo;
	private JLabel lbl_nombres, lbl_contrasenha;
	private JTextField tf_nombres;
	private JPasswordField pf_contrasenha;
	private JButton btn_aceptar;
	
	public Login() {
		super("Ingresar al sistema");
		setSize(600, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		ImageIcon icon=new ImageIcon("geppeto_tienda.png");
		
		
		lbl_titulo=new JLabel();
		lbl_titulo.setBounds(90, 10, 500, 100);
		lbl_titulo.setIcon(icon);
		add(lbl_titulo);
		
		lbl_nombres=new JLabel("Nombre(s):");
		lbl_nombres.setBounds(50, 120, 100, 30);
		add(lbl_nombres);
		
		tf_nombres=new JTextField();
		tf_nombres.setBounds(160, 125, 200, 20);
		add(tf_nombres);
		
		lbl_contrasenha=new JLabel("Contraseña:");
		lbl_contrasenha.setBounds(50, 160, 150, 30);
		add(lbl_contrasenha);
		
		pf_contrasenha=new JPasswordField();
		pf_contrasenha.setBounds(160, 165, 200, 20);
		add(pf_contrasenha);
		
		btn_aceptar=new JButton("Aceptar");
		btn_aceptar.setBounds(50, 200, 100, 30);
		add(btn_aceptar);
	}

	public JTextField getTf_nombres() {
		return tf_nombres;
	}

	public void setTf_nombres(JTextField tf_nombres) {
		this.tf_nombres = tf_nombres;
	}

	public JPasswordField getPf_contrasenha() {
		return pf_contrasenha;
	}

	public void setPf_contrasenha(JPasswordField pf_contrasenha) {
		this.pf_contrasenha = pf_contrasenha;
	}

	public JButton getBtn_aceptar() {
		return btn_aceptar;
	}

	public void setBtn_aceptar(JButton btn_aceptar) {
		this.btn_aceptar = btn_aceptar;
	}
	

}
