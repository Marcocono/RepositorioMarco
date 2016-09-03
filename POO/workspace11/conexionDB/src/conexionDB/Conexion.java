package conexionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	Connection conexion;
	private String url = "jdbc:mysql://localhost/db_facturacion";
	private String usuario = "root";
	private String contrasena = "";
	private Statement instruccion;
	private ResultSet resultado;
	
	//PARA LLAMAR AL DRIVER DE LA BASE DE DATOS
	public Conexion(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url,usuario,contrasena);
			String sql = "SELECT codigo_marca, " 
					+ "nombre_marca " 
					+"FROM tbl_marcas";
			resultado =  instruccion.executeQuery(sql);
			while(resultado.next()){
				System.out.println("codigo: " + resultado.getInt("codigo_marca") + "Nombre Marca: "+ resultado.getString("nombre_marca") );
			}
			conexion.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
	}
}
