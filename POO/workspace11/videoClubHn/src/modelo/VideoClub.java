package modelo;

import java.util.Date;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class VideoClub {
	private IntegerProperty codigoProducto;
	private StringProperty nombre;
	private StringProperty descripccion;
	private StringProperty categoria;
	private StringProperty vendedor;
	private Date fechaRenta;
	private Date fechaDevolucion;
	private StringProperty estatus;
	private StringProperty prioridadAlta;
	private StringProperty prioridadBaja;

	
	public VideoClub(int codigoProducto, 
			String nombre,
			String descripccion, 
			String categoria,
			String vendedor, 
			Date fechaRenta, 
			Date fechaDevolucion,
			String estatus,
			String prioridadAlta,
			String prioridadBaja) {
		
		this.codigoProducto = new SimpleIntegerProperty (codigoProducto);
		this.nombre = new SimpleStringProperty(nombre);
		this.descripccion = new SimpleStringProperty( descripccion );
		this.categoria = new SimpleStringProperty( categoria );
		this.vendedor = new SimpleStringProperty( vendedor );
		this.fechaRenta = fechaRenta;
		this.fechaDevolucion = fechaDevolucion;
		this.estatus = new SimpleStringProperty( estatus );
		this.prioridadAlta = new SimpleStringProperty( prioridadAlta );
		this.prioridadBaja = new SimpleStringProperty( prioridadBaja );
	}

	public VideoClub(){
		
	}
	
	//Estructura BEANS
	
	public IntegerProperty CodigoProductoProperty() {
		return this.codigoProducto;
	}
	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = new SimpleIntegerProperty(codigoProducto);
	}
	public int getCodigoProducto(){
		return codigoProducto.get();
	}
	
	
	public StringProperty NombreProperty() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = new SimpleStringProperty (nombre);
	}
	public String getNombre(){
		return nombre.get();
	}
	
	
	public StringProperty DescripccionProperty() {
		return this.descripccion;
	}
	public void setDescripccion(String descripccion) {
		this.descripccion = new SimpleStringProperty(descripccion);
	}
	public String getDescripccion(){
		return descripccion.get();
	}
	
	
	public StringProperty CategoriaProperty() {
		return this.categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = new SimpleStringProperty( categoria );
	}
	public String getCategoria(){
		return categoria.get();
	}
	
	
	public StringProperty VendedorProperty() {
		return this.vendedor;
	}
	public void setVendedor(String vendedor) {
		this.vendedor = new SimpleStringProperty (vendedor);
	}
	public String getVendedor(){
		return vendedor.get();
	}
	
	public Date getFechaRenta() {
		return fechaRenta;
	}
	public void setFechaRenta(Date fechaRenta) {
		this.fechaRenta = fechaRenta;
	}
	
	
	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}
	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	
	
	public StringProperty EstatusProperty() {
		return this.estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = new SimpleStringProperty( estatus );
	}
	public String getEstatus(){
		return estatus.get();
	}
	
	
	public StringProperty PrioridadAltaProperty() {
		return this.prioridadAlta;
	}
	public void setPrioridad(String prioridadAlta) {
		this.prioridadAlta = new SimpleStringProperty( prioridadAlta );
	}
	public String getPrioridadAlta(){
		return prioridadAlta.get();
	}

	public StringProperty PrioridadBajaProperty() {
		return this.prioridadBaja;
	}
	public void setPrioridadBaja(String prioridadBaja) {
		this.prioridadBaja = new SimpleStringProperty( prioridadBaja );
	}
	public String getPrioridadBaja(){
		return prioridadBaja.get();
	}
	@Override
	public String toString() {
		return   codigoProducto + "\t\t"
				+ nombre + "\t\t" + descripccion + "\t\t"
				+ categoria + "\t\t" + vendedor + "\t\t"
				+ fechaRenta + "\t\t" + fechaDevolucion
				+ "\t\t" + estatus + "\t\t" + prioridadAlta ;
	}
	

}
