package modelo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Cliente extends Usuario {


	private IntegerProperty codigoCliente;
	private StringProperty nombreCliente;
	private IntegerProperty numeroIdentidad;
	private IntegerProperty telefono;
	private IntegerProperty demoras;

	
	public Cliente(Integer codigoUsuario, String cargo, String nombreUsuario) {
		super(codigoUsuario, cargo, nombreUsuario);
		// TODO Auto-generated constructor stub
	}
	
	//RECORDAR MODIFICAR
	public Cliente(
			Integer codigoCliente, 
			String nombreCliente, 
			Integer numeroIdentidad,
			Integer telefono,
			Integer demoras){
		super(demoras, nombreCliente, nombreCliente);
		this.codigoCliente = new SimpleIntegerProperty(codigoCliente);
		this.nombreCliente = new SimpleStringProperty(nombreCliente);
		this.numeroIdentidad = new SimpleIntegerProperty(numeroIdentidad);
		this.telefono = new SimpleIntegerProperty(telefono);
		this.demoras = new SimpleIntegerProperty(demoras);
	}
	
	
	
	public Integer getCodigoCliente(){
		return codigoCliente.get();
	}

	public void setCodigoCliente(Integer codigoCliente){
		this.codigoCliente = new SimpleIntegerProperty(codigoCliente);
	}

	public String getNombreCliente(){
		return nombreCliente.get();
	}

	public void setNombreCliente(String nombreCliente){
		this.nombreCliente = new SimpleStringProperty(nombreCliente);
	}

	public Integer getNumeroIdentidad(){
		return numeroIdentidad.get();
	}

	public void setNumeroIdentidad(Integer numeroIdentidad){
		this.numeroIdentidad = new SimpleIntegerProperty(numeroIdentidad);
	}

	public Integer getTelefono(){
		return telefono.get();
	}

	public void setTelefono(Integer telefono){
		this.telefono = new SimpleIntegerProperty(telefono);
	}

	public Integer getDemoras(){
		return demoras.get();
	}

	public void setDemoras(Integer demoras){
		this.demoras = new SimpleIntegerProperty(demoras);
	}

	public IntegerProperty codigoClienteProperty(){
		return codigoCliente;
	}

	public StringProperty nombreClienteProperty(){
		return nombreCliente;
	}

	public IntegerProperty numeroIdentidadProperty(){
		return numeroIdentidad;
	}

	public IntegerProperty telefonoProperty(){
		return telefono;
	}

	public IntegerProperty demorasProperty(){
		return demoras;
	}
}
