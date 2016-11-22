package modelo;

import java.io.FileInputStream;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UsuarioDAO {
	private Conexion conexion;
	
	public UsuarioDAO() {
		conexion=new Conexion();
	}
	public boolean agregar(Usuario usuario) {
		
		
		String sentenciaSQL;
		System.out.println(conexion.conectar());
		
		
		boolean rpta=false;
		
		try { 
		//File fichero = new File(dirArchivo); 
		
		sentenciaSQL="INSERT INTO usuarios VALUES(?,?,?,?,PWDENCRYPT(?),?,?)";
		PreparedStatement pstmt = conexion.getC().prepareStatement(sentenciaSQL); 
		//int len = streamEntrada.available(); 
		//Nombre del archivo 
		pstmt.setString(1, usuario.getNombres());
		pstmt.setString(2, usuario.getApellidos());
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	
		Calendar fecha = usuario.getFecha_nacimiento();
		
		pstmt.setString(3, sdf.format(fecha.getTime()));
		
		Calendar fecha1=usuario.getFecha_registro();
		
		pstmt.setString(4, sdf.format(fecha1.getTime()));
		
		pstmt.setString(5, usuario.getContrasenha());
		
		FileInputStream streamEntrada = new FileInputStream(usuario.getFoto());
		pstmt.setBinaryStream(6, streamEntrada, (int)usuario.getFoto().length());
		
		pstmt.setString(7, String.valueOf(usuario.getTipo_usuario()));
				 
		pstmt.executeUpdate(); 
		pstmt.close(); 
		streamEntrada.close(); 
		rpta=true; 
		} 
		catch(Exception e) { 
		e.printStackTrace(); 
		} 
		
		conexion.desconectar();
		
		
		return rpta;
		
	}

}
