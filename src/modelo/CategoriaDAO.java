package modelo;

import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CategoriaDAO {
	private Conexion conexion;
	
	
	public CategoriaDAO() {
		conexion=new Conexion();
	}
	
	public boolean agregar(Categoria categoria) {
		
		
		String sentenciaSQL;
		//System.out.println(conexion.conectar());
		conexion.conectar();
		
		boolean rpta=false;
		
		try { 
		//File fichero = new File(dirArchivo); 
		
		sentenciaSQL="INSERT INTO categorias VALUES(?,?,?)";
		PreparedStatement pstmt = conexion.getC().prepareStatement(sentenciaSQL); 
		//int len = streamEntrada.available(); 
		//Nombre del archivo 
		pstmt.setString(1, categoria.getNombre());
		pstmt.setString(2, categoria.getDescripcion());
				
		FileInputStream streamEntrada = new FileInputStream(categoria.getFoto());
		pstmt.setBinaryStream(3, streamEntrada, (int)categoria.getFoto().length());
						 
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
