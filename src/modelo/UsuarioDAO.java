package modelo;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class UsuarioDAO {
	private Conexion conexion;
	
	public UsuarioDAO() {
		conexion=new Conexion();
	}
	public boolean agregar(Usuario usuario) {
		
		
		String sentenciaSQL;
		//System.out.println(conexion.conectar());
		conexion.conectar();
		
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
		
		pstmt.setInt(7, (usuario.getTipo_usuario()));
				 
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
	public Usuario logear(String nombre, String contra) {
		Usuario usuario=new Usuario();
		
		//System.out.println(conexion.conectar());
		conexion.conectar();
		
		try {
			String sentenciaSQL="SELECT * FROM usuarios where nombres=? and PWDCOMPARE(?, contrasenha)=1";
			PreparedStatement pstmt = conexion.getC().prepareStatement(sentenciaSQL);
            
            pstmt.setString(1, nombre);
            pstmt.setString(2, contra);
            
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
            	usuario.setId_usuario(rs.getInt("id_usuario"));
            	usuario.setNombres(rs.getString("nombres"));
            	usuario.setApellidos(rs.getString("apellidos"));
            	
            	Calendar calendar=Calendar.getInstance();
        		calendar.setTime(rs.getDate("fecha_nacimiento"));
        		usuario.setFecha_nacimiento(calendar);
        		
        		Calendar calendar1=Calendar.getInstance();
        		calendar1.setTime(rs.getDate("fecha_registro"));
        		usuario.setFecha_registro(calendar1);            	
            	
            	InputStream in = rs.getBinaryStream("foto");//leemos la imagen
	            Image image = ImageIO.read(in);
	            
	            usuario.setImagen(image);
	            usuario.setTipo_usuario((byte) rs.getInt("tipo_usuario"));           
	            
	            in.close();
	            
            }
            
            rs.close();
            pstmt.close();
            //return img;
            //System.out.println(conexion.desconectar());
            conexion.desconectar();
 } catch (Exception e) {
            System.err.println("Error al acceder al registro: " + e.getMessage());
 }
		
		
		return usuario;
		
	}

}
