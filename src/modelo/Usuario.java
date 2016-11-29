package modelo;

import java.awt.Image;
import java.io.File;
import java.util.Calendar;

public class Usuario {
	private int id_usuario;
	private String nombres;
	private String apellidos;
	private Calendar fecha_nacimiento;
	private Calendar fecha_registro;
	private String contrasenha;
	private File foto;
	private byte tipo_usuario;
	private Image imagen;
		
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Calendar getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Calendar fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public Calendar getFecha_registro() {
		return fecha_registro;
	}
	public void setFecha_registro(Calendar fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	public String getContrasenha() {
		return contrasenha;
	}
	public void setContrasenha(String contrasenha) {
		this.contrasenha = contrasenha;
	}
	public byte getTipo_usuario() {
		return tipo_usuario;
	}
	public void setTipo_usuario(byte tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}
	public void setFoto(File foto) {
		this.foto = foto;
	}	
	public File getFoto() {
		return foto;
	}
	public Image getImagen() {
		return imagen;
	}
	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}
	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nombres=" + nombres + ", apellidos=" + apellidos
				+ ", fecha_nacimiento=" + fecha_nacimiento + ", fecha_registro=" + fecha_registro + ", contrasenha="
				+ contrasenha + ", foto=" + foto + ", tipo_usuario=" + tipo_usuario + ", imagen=" + imagen + "]";
	}
	
	
	
	
	

}
