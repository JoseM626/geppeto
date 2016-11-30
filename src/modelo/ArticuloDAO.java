package modelo;

import java.io.FileInputStream;
import java.sql.PreparedStatement;

public class ArticuloDAO {
	Conexion conexion=new Conexion();
	
	public ArticuloDAO() {
		conexion=new Conexion();
	}
	
	
	
	public boolean agregar(Articulo articulo) {
		
		
		String sentenciaSQL;
		//System.out.println(conexion.conectar());
		conexion.conectar();
		
		boolean rpta=false;
		
		try { 
		
		sentenciaSQL="INSERT INTO articulos VALUES(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conexion.getC().prepareStatement(sentenciaSQL); 
		
		pstmt.setString(1, articulo.getNombre());
		pstmt.setString(2, articulo.getDescripcion());
		pstmt.setDouble(3, articulo.getCosto());
		pstmt.setInt(4, articulo.getExistencia());
		pstmt.setString(5, articulo.getHistoria());
		pstmt.setInt(6, articulo.getId_categoria());
						
		FileInputStream streamEntrada = new FileInputStream(articulo.getFoto());
		pstmt.setBinaryStream(7, streamEntrada, (int)articulo.getFoto().length());
		
		pstmt.setInt(8, articulo.getAnho());
								 
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
