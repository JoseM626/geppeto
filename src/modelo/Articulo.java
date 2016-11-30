package modelo;

import java.awt.Image;
import java.io.File;

public class Articulo {
	private int id_articulo;
	private String nombre;
	private String descripcion;
	private double costo;
	private int existencia;
	private String historia;
	private int id_categoria;
	private File foto;
	private Image imagen;
	private int anho;
	public int getId_articulo() {
		return id_articulo;
	}
	public void setId_articulo(int id_articulo) {
		this.id_articulo = id_articulo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public int getExistencia() {
		return existencia;
	}
	public void setExistencia(int existencia) {
		this.existencia = existencia;
	}
	public String getHistoria() {
		return historia;
	}
	public void setHistoria(String historia) {
		this.historia = historia;
	}
	public int getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	public File getFoto() {
		return foto;
	}
	public void setFoto(File foto) {
		this.foto = foto;
	}
	public Image getImagen() {
		return imagen;
	}
	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}
	public int getAnho() {
		return anho;
	}
	public void setAnho(int anho) {
		this.anho = anho;
	}
	@Override
	public String toString() {
		return "Articulo [id_articulo=" + id_articulo + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", costo=" + costo + ", existencia=" + existencia + ", historia=" + historia + ", id_categoria="
				+ id_categoria + ", foto=" + foto + ", imagen=" + imagen + ", anho=" + anho + "]";
	}
	
	

}
