package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.Usuarios_agregar;

public class Usuarios_agregar_controlador implements ActionListener {
	private Usuarios_agregar ventana;
	private JFileChooser fc;
	private Usuario usuario;
	private UsuarioDAO usuario_dao;
	private File source;
	
	public Usuarios_agregar_controlador() {
		ventana=new Usuarios_agregar();
		ventana.getBtn_foto().addActionListener(this);
		ventana.getBtn_agregar().addActionListener(this);
		
		fc=new JFileChooser();
		FileNameExtensionFilter filter=new FileNameExtensionFilter("PNG, JPG & GIF", "png", "jpg", "gif");
		fc.setFileFilter(filter);
		usuario=new Usuario();
		usuario_dao=new UsuarioDAO();
		
		ImageIcon icon=new ImageIcon("usuario.png");
		ventana.getLbl_foto().setIcon(icon);
		
		source=new File("usuario.png");
		
	}
	public static void main(String[] args) {
		Usuarios_agregar_controlador uac=new Usuarios_agregar_controlador();
		uac.ventana.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==ventana.getBtn_foto()) {
			int valor=fc.showOpenDialog(ventana);
			if(valor==JFileChooser.APPROVE_OPTION) {
				String path=fc.getSelectedFile().getPath();
				//System.out.println(path);
				ImageIcon icon=new ImageIcon(path);
				//System.out.println("Width:"+icon.getIconWidth());
				//System.out.println("Height:"+icon.getIconHeight());
				ventana.getLbl_foto().setIcon(icon);
				source=new File(path);
			}
		}
		if(arg0.getSource()==ventana.getBtn_agregar()) {
			usuario.setNombres(ventana.getTf_nombres().getText());
			usuario.setApellidos(ventana.getTf_apellidos().getText());
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
			Date date = new Date();
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(date);
	        ventana.getTf_fecha_registro().setText(sdf.format(date));
	        usuario.setFecha_registro(calendar);
	        
	        String dateInString = ventana.getTf_fecha_nacimiento().getText();
	        try {
	        	Date date1 = new Date();
	        	Calendar calendar1 = Calendar.getInstance();
				date1 = sdf.parse(dateInString);
				calendar1.setTime(date1);
				usuario.setFecha_nacimiento(calendar1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        //System.out.println(usuario.getFecha_nacimiento()); //Tue Aug 31 10:20:56 SGT 1982
	        usuario.setContrasenha(String.copyValueOf(ventana.getPf_contrasenha().getPassword()));

	        usuario.setFoto(source);
	        
	        
	        usuario.setTipo_usuario((byte) ventana.getCb_tipo_usuario().getSelectedIndex());
	        
	        //System.out.println(ventana.getCb_tipo_usuario().getSelectedIndex());
	        
	        //System.out.println(source.getAbsolutePath());
	        System.out.println(usuario.toString());
	        
	        System.out.println(usuario_dao.agregar(usuario));
	        
	        
	        
	        
	        
			
		}
		
	}

}
