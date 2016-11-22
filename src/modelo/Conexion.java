package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
	private Connection c;
	private String usr;
	private String pwd;
	private String driver;
	private String sql;
	private PreparedStatement pstm;
	private boolean respuesta;
	private ResultSet rs;
	
public Conexion() {
	this.c=null;
	this.usr="simply";
	this.pwd="$imply16";
	this.driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	this.sql="";
	this.pstm=null;
	this.respuesta=false;
	this.rs=null;
}
public boolean conectar() {
respuesta=false;
	
	try {
		Class.forName(driver);
		c=DriverManager.getConnection("jdbc:sqlserver://drtec.ddns.net:1433;databaseName=geppetto;", this.usr, this.pwd);
		//c=DriverManager.getConnection("jdbc:sqlserver://localhost", this.usr, this.pwd);
		respuesta=true;
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	return respuesta;
	
}
public boolean desconectar() {
respuesta=false;
	
	try {
		if(!c.isClosed()) {
			c.close();
		}
		respuesta=true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return respuesta;
	
}
public Connection getC() {
	return c;
}


}
