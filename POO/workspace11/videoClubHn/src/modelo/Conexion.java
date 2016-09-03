package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
// CLASE PARA CONECTARSE A LA BASE DE DATOS PARA HACER CONSULTAS
	private Connection conexion;
	private String url = "jdbc:mysql://localhost/db_facturacion";
	private String usuario = "root";
	private String contrasena = "";
	
	public void conexion(){
		
	}
	public void establecerConexion(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url,usuario,contrasena);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void cerrarConexion(){
		try {
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void llenarInformacionMarcas(ObservableList<String> lista){
		//REcordarAgregarle el try and catch
		Statement instruccion = conexion.createStatement();
		ResultSet resultado = 
				instruccion.executeQuery("SELECT codigo_marca, " 
					+ "nombre_marca " 
					+"FROM tbl_marcas");
		while(resultado.next()){
			System.out.println("codigo: " + resultado.getInt("codigo_marca") + "Nombre Marca: "+ resultado.getString("nombre_marca") );
		}
	}
	
	public void llenarInformacionLotes(ObservableList<String> lotes){
		//recordarAgregarke ek try and catch
		Statement instruccion = conexion.createStatement();
		ResultSet resultado = instruccion.executeQuery("SELECT codigo_lote, lote "
				+ "FROM tbl_lotes");
		while ( resultado.next()){
		//LOL
		}
		
			
	}
	
}


