package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class Moneda {
	private IntegerProperty codigoMoneda;
	private StringProperty nombreMoneda;

	public Moneda(Integer codigoMoneda, String nombreMoneda){
		this.codigoMoneda = new SimpleIntegerProperty(codigoMoneda);
		this.nombreMoneda = new SimpleStringProperty(nombreMoneda);
	}

	public Integer getCodigoMoneda(){
		return codigoMoneda.get();
	}

	public void setCodigoMoneda(Integer codigoMoneda){
		this.codigoMoneda = new SimpleIntegerProperty(codigoMoneda);
	}

	public String getNombreMoneda(){
		return nombreMoneda.get();
	}

	public void setNombreMoneda(String nombreMoneda){
		this.nombreMoneda = new SimpleStringProperty(nombreMoneda);
	}

	public IntegerProperty codigoMonedaProperty(){
		return codigoMoneda;
	}

	public StringProperty nombreMonedaProperty(){
		return nombreMoneda;
	}

	
	//RECORDAR MODIFICAR LA SENTENCIA SQL
	public static void llenarInformacion(Connection connection, ObservableList<Moneda> lista) {
		try {
			Statement stament = connection.createStatement() ;
			ResultSet resultado = stament.executeQuery(
					"SELECT codigo_moneda, "
					+"nombre_moneda "
					 + "FROM tbl_moneda");
			while(resultado.next()) {
				lista.add(new Moneda(	resultado.getInt("codigo_moneda"), 
										resultado.getString("nombre_moneda")
										)
											);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
