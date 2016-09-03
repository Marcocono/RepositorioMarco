package modelo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Usuario {
	private IntegerProperty codigoUsuario;
	private StringProperty cargo;
	private StringProperty nombreUsuario;

	public Usuario(Integer codigoUsuario, String cargo, String nombreUsuario){
		this.codigoUsuario = new SimpleIntegerProperty(codigoUsuario);
		this.cargo = new SimpleStringProperty(cargo);
		this.nombreUsuario = new SimpleStringProperty(nombreUsuario);
	}

	public Integer getCodigoUsuario(){
		return codigoUsuario.get();
	}

	public void setCodigoUsuario(Integer codigoUsuario){
		this.codigoUsuario = new SimpleIntegerProperty(codigoUsuario);
	}

	public String getCargo(){
		return cargo.get();
	}

	public void setCargo(String cargo){
		this.cargo = new SimpleStringProperty(cargo);
	}

	public String getNombreUsuario(){
		return nombreUsuario.get();
	}

	public void setNombreUsuario(String nombreUsuario){
		this.nombreUsuario = new SimpleStringProperty(nombreUsuario);
	}

	public IntegerProperty codigoUsuarioProperty(){
		return codigoUsuario;
	}

	public StringProperty cargoProperty(){
		return cargo;
	}

	public StringProperty nombreUsuarioProperty(){
		return nombreUsuario;
	}

}
