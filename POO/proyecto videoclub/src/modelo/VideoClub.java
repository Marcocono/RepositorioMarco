package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class VideoClub {
	// FORMULARIO DE VENTAS
	
	private IntegerProperty codigoVenta;
	private IntegerProperty cantidadPeliculas;
	private IntegerProperty precioAlquiler;
	private IntegerProperty total;
	private StringProperty nombre_videoClub;
	private StringProperty descripcion_videoClub;
	private DoubleProperty total_pagar;
	
	
	private Usuario usuario;
	private Pelicula pelicula;
	private Moneda moneda;
	private Date fechaRenta;
	private Date fechaDevolucion;
	private Cliente cliente;
	
	public VideoClub(Integer codigoVenta) {
		
		this.codigoVenta = new SimpleIntegerProperty(codigoVenta);
	}
	
	
	public VideoClub(
			Integer codigoVenta, 
			Integer cantidadPeliculas,
			Integer precioAlquiler, 
			Integer total,
			Cliente cliente,
			Pelicula pelicula,
			Moneda moneda,
			Date fechaRenta , 
			Date fechaDevolucion, 
			Usuario usuario){
			
		this.codigoVenta = new SimpleIntegerProperty(codigoVenta);
		this.cantidadPeliculas = new SimpleIntegerProperty(cantidadPeliculas);
		this.precioAlquiler = new SimpleIntegerProperty(precioAlquiler);
		this.total = new SimpleIntegerProperty(total);
		this.cliente = cliente;
		this.pelicula = pelicula;
		this.moneda = moneda;
		this.fechaRenta = fechaRenta;
		this.fechaDevolucion = fechaDevolucion;
		this.usuario = usuario;
	}
	//-------------------------------------------
	//Metodo bueno
	public int guardarRegistro(Conexion conexion) {
		
		try {
			PreparedStatement ps = conexion.getConexion().prepareStatement(
					"INSERT INTO tbl_videoclub ( " +
					"nombre_videoclub, descripcion_videoclub, "+
					"fecha_renta, fecha_devolucion, "+
					"total_pagar, codigo_moneda, "+
					"codigo_pelicula, codigo_usuario) "+
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			
			ps.setString(1, nombre_videoClub.get());
			ps.setString(2, descripcion_videoClub.get());
			ps.setDate(3, fechaDevolucion);
			ps.setDate(4, fechaRenta);
			ps.setDouble(5 ,total_pagar.get());
			ps.setInt(6, moneda.getCodigoMoneda());
			ps.setInt(7,pelicula.getCodigoPelicula());
			ps.setInt(8, usuario.getCodigoUsuario());

			return ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	
	}
	
	public static void llenarTableView(Connection connection,ObservableList<VideoClub> lista) {
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultado = statement.executeQuery(
					"SELECT codigo_videoclub, " +
					"nombre_videoclub " +
				"FROM tbl_videoclub " );
			while(resultado.next()) {
				
				lista.add(new VideoClub(resultado.getInt("codigo_videoclub")));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public int eliminarRegistro(Conexion conexion) {
		return 0;
	}
	
	public int modificarRegistro(Conexion conexion) {
		return 0;
	}
	
	public Integer getCodigoVenta(){
		return codigoVenta.get();
	}

	public void setCodigoVenta(Integer codigoVenta){
		this.codigoVenta = new SimpleIntegerProperty(codigoVenta);
	}

	public Integer getCantidadPeliculas(){
		return cantidadPeliculas.get();
	}

	public void setCantidadPeliculas(Integer cantidadPeliculas){
		this.cantidadPeliculas = new SimpleIntegerProperty(cantidadPeliculas);
	}

	public Integer getPrecioAlquiler(){
		return precioAlquiler.get();
	}

	public void setPrecioAlquiler(Integer precioAlquiler){
		this.precioAlquiler = new SimpleIntegerProperty(precioAlquiler);
	}

	public Integer getTotal(){
		return total.get();
	}

	public void setTotal(Integer total){
		this.total = new SimpleIntegerProperty(total);
	}

	public IntegerProperty codigoVentaProperty(){
		return codigoVenta;
	}

	public IntegerProperty cantidadPeliculasProperty(){
		return cantidadPeliculas;
	}

	public IntegerProperty precioAlquilerProperty(){
		return precioAlquiler;
	}

	public IntegerProperty totalProperty(){
		return total;
	}
	//---------------------------------
	public Usuario getUsuario() {
		return usuario;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public Date getFechaRenta() {
		return fechaRenta;
	}

	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public void setFechaRenta(Date fechaRenta) {
		this.fechaRenta = fechaRenta;
	}

	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}

