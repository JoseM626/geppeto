package modelo;

import java.io.FileInputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

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
	public Vector traer() {
		Vector categorias=new Vector();
		
		conexion.conectar();
		String sql;
		
		try {
			sql="SELECT nombre FROM categorias ORDER BY nombre";
			PreparedStatement pstm=conexion.getC().prepareStatement(sql);
			ResultSet rs=pstm.executeQuery();
			while(rs.next()) {
				categorias.add(rs.getString("nombre"));
			}
			pstm.close();
		}catch(SQLException ex1) {
			System.out.println(ex1.getMessage());
		}
		
		conexion.desconectar();
		
		
		
		return categorias;
	}
	public int traer_id(String nombre) {
		int respuesta=0;
		
		conexion.conectar();
		String sql;
		
		try {
			sql="SELECT id_categoria FROM categorias where nombre=?";
			PreparedStatement pstm=conexion.getC().prepareStatement(sql);
			pstm.setString(1, nombre);
			ResultSet rs=pstm.executeQuery();
			if(rs.next()) {
				respuesta=rs.getInt("id_categoria");
			}
			pstm.close();
		}catch(SQLException ex1) {
			System.out.println(ex1.getMessage());
		}
		
		conexion.desconectar();
		
		
		
		return respuesta;
	}

}
