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

public class Pelicula extends Articulo {
	private IntegerProperty codigoPelicula;
	private StringProperty nombre_pelicula;
	private StringProperty categoriaPelicula;
	private StringProperty descripcionPelicula;
	private StringProperty formatoPelicula;
	private StringProperty estatus;
	private Connection conexion;


	public Pelicula(
			Integer codigoPelicula, 
			String nombre_pelicula, 
			String categoriaPelicula,
			String descripcionPelicula, 
			String formatoPelicula,
			String estatus){
		this.codigoPelicula = new SimpleIntegerProperty(codigoPelicula);
		this.nombre_pelicula = new SimpleStringProperty(nombre_pelicula);
		this.categoriaPelicula = new SimpleStringProperty(categoriaPelicula);
		this.descripcionPelicula = new SimpleStringProperty(descripcionPelicula);
		this.formatoPelicula = new SimpleStringProperty(formatoPelicula);
		this.estatus = new SimpleStringProperty(estatus);
	}
	
	public static void llenarInformacion(Connection conexion, ObservableList<Pelicula> lista) {
		Statement statement;
		try {
			statement = conexion.createStatement();
			ResultSet resultado = statement.executeQuery(
					"SELECT codigo_pelicula, " + 
					"nombre_pelicula, " + 
					"categoria_pelicula, " +
					"descripcion_pelicula, " +
					"formato_pelicula, " +
					"estatus " +
					"FROM tbl_pelicula"
					);
			while(resultado.next()) {
				lista.add(new Pelicula(
						resultado.getInt("codigo_pelicula"), 
						resultado.getString("nombre_pelicula"),
						resultado.getString("categoria_pelicula"), 
						resultado.getString("descripcion_pelicula"), 
						resultado.getString("formato_pelicula"), 
						resultado.getString("estatus")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Integer getCodigoPelicula(){
		return codigoPelicula.get();
	}

	public void setCodigoPelicula(Integer codigoPelicula){
		this.codigoPelicula = new SimpleIntegerProperty(codigoPelicula);
	}

	public String getNombre_pelicula(){
		return nombre_pelicula.get();
	}

	public void setNombre_pelicula(String nombre_pelicula){
		this.nombre_pelicula = new SimpleStringProperty(nombre_pelicula);
	}

	public String getCategoriaPelicula(){
		return categoriaPelicula.get();
	}

	public void setCategoriaPelicula(String categoriaPelicula){
		this.categoriaPelicula = new SimpleStringProperty(categoriaPelicula);
	}

	public String getDescripcionPelicula(){
		return descripcionPelicula.get();
	}

	public void setDescripcionPelicula(String descripcionPelicula){
		this.descripcionPelicula = new SimpleStringProperty(descripcionPelicula);
	}

	public String getFormatoPelicula(){
		return formatoPelicula.get();
	}

	public void setFormatoPelicula(String formatoPelicula){
		this.formatoPelicula = new SimpleStringProperty(formatoPelicula);
	}

	public String getEstatus(){
		return estatus.get();
	}

	public void setEstatus(String estatus){
		this.estatus = new SimpleStringProperty(estatus);
	}

	public IntegerProperty codigoPeliculaProperty(){
		return codigoPelicula;
	}

	public StringProperty nombre_peliculaProperty(){
		return nombre_pelicula;
	}

	public StringProperty categoriaPeliculaProperty(){
		return categoriaPelicula;
	}

	public StringProperty descripcionPeliculaProperty(){
		return descripcionPelicula;
	}

	public StringProperty formatoPeliculaProperty(){
		return formatoPelicula;
	}

	public StringProperty estatusProperty(){
		return estatus;
	}
	
	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

}
