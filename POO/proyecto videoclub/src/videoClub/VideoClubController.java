package videoClub;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Cliente;
import modelo.Conexion;
import modelo.Moneda;
import modelo.Pelicula;
import modelo.Usuario;
import modelo.VideoClub;


public class VideoClubController implements Initializable{

	@FXML private ComboBox<Pelicula> cboPelicula;
	@FXML private ComboBox<Moneda> cboMoneda;
	
	@FXML private Button btnAgregar;
	@FXML private Button btnEliminar;
	@FXML private Button btnModificar;
	
	@FXML private TextField txtCodigo;
	@FXML private TextField txtNombre;
	@FXML private TextField txtDescripcion;
	@FXML private TextField txtEstatus;
	@FXML private TextField txtIdentidadCliente;
	@FXML private TextField txtNombreCliente;
	@FXML private TextField txtTelefono;
	@FXML private TextField txtDemoraLempiras;
	@FXML private TextField txtDemoraDolares;
	@FXML private TextField txtCantidadPeliculas;
	//Revisar el precio a alquiler y verificar si es estreno o no
	@FXML private TextField txtPrecioAlquiler;
	@FXML private TextField txtTotal;
	
	@FXML private TableView<VideoClub> tblInformacion;
	
	private Conexion conexion;
	
	private ObservableList<Moneda> listaMoneda;
	private ObservableList<Pelicula> listaPelicula;
	private ObservableList<VideoClub> informacion;
	
	
	@FXML private TableColumn<VideoClub,Number> clmnCodigoVenta;
	@FXML private TableColumn<VideoClub,String> clmnCodigoCliente;
	@FXML private TableColumn<VideoClub,String> clmnNombrePelicula;
	@FXML private TableColumn<VideoClub,String> clmnNombreCliente;
	@FXML private TableColumn<VideoClub,Date> clmnFechaDevolucion;
	
	private Main main;
	
	/*
	@FXML private TableColumn<VideoClub,String> clmnDescripcionPelicula;
	@FXML private TableColumn<VideoClub,String> clmnUsuario;
	@FXML private TableColumn<VideoClub,String> clmnEstatusPelicula;
	@FXML private TableColumn<VideoClub,Moneda> clmnMoneda;
	@FXML private TableColumn<VideoClub,Date> clmnFechaRenta;
	@FXML private TableColumn<VideoClub,Long> clmnIdentidad;
	@FXML private TableColumn<VideoClub,Long> clmnTelefono;
	@FXML private TableColumn<VideoClub,Number> clmnDemorasLempiras;
	@FXML private TableColumn<VideoClub,Number> clmnDemorasDolares;
	@FXML private TableColumn<VideoClub,Number> clmnCantidadPeliculas;
	@FXML private TableColumn<VideoClub,Number> clmnPrecioAlquiler;
	@FXML private TableColumn<VideoClub,Number> clmnTotal;

	 */
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		/*
		 * 
		 clmnCodigoVenta.setCellValueFactory(new PropertyValueFactory<VideoClub,Number>("codigoCliente"));
		clmnDescripcionPelicula.setCellValueFactory(new PropertyValueFactory<VideoClub,String>("descripcionPelicula"));
		clmnUsuario.setCellValueFactory(new PropertyValueFactory<VideoClub,String>("Usuario"));
		clmnEstatusPelicula.setCellValueFactory(new PropertyValueFactory<VideoClub,String>("EstatusPelicula"));
		clmnCategoria.setCellValueFactory(new PropertyValueFactory<VideoClub,Pelicula>("categoria"));
		clmnMoneda.setCellValueFactory(new PropertyValueFactory<VideoClub,Moneda>("moneda"));
		clmnFechaRenta.setCellValueFactory(new PropertyValueFactory<VideoClub,Date>("fechaRenta"));
		clmnIdentidad.setCellValueFactory(new PropertyValueFactory<VideoClub,Long>("identidad"));
		clmnTelefono.setCellValueFactory(new PropertyValueFactory<VideoClub,Long>("telefono"));
		clmnDemorasLempiras.setCellValueFactory(new PropertyValueFactory<VideoClub,Number>("demorasLempiras"));
		clmnDemorasDolares.setCellValueFactory(new PropertyValueFactory<VideoClub,Number>("demorasDolares"));
		clmnCantidadPeliculas.setCellValueFactory(new PropertyValueFactory<VideoClub,Number>("cantidadPeliculas"));
		clmnPrecioAlquiler.setCellValueFactory(new PropertyValueFactory<VideoClub,Number>("precioAlquiler"));
		clmnTotal.setCellValueFactory(new PropertyValueFactory<VideoClub,Number>("total"));
		*/
		
		conexion = new Conexion();
		conexion.establecerConexion();
		
		//se enlistan 
		
		listaMoneda = FXCollections.observableArrayList();
		listaPelicula = FXCollections.observableArrayList();
		informacion = FXCollections.observableArrayList();
		//llenar listas
		
		Moneda.llenarInformacion(conexion.getConexion(), listaMoneda);
		Pelicula.llenarInformacion(conexion.getConexion(), listaPelicula);
		VideoClub.llenarTableView(conexion.getConexion(), informacion);
		
		
		
		cboPelicula.setItems(listaPelicula);
		cboMoneda.setItems(listaMoneda);
		tblInformacion.setItems(informacion);
		
		//ENLAZAR COLUMNAS CON ATRIBUTOS
		
		
		clmnCodigoVenta.setCellValueFactory(new PropertyValueFactory<VideoClub,Number>("codigoVenta"));
		
		/*clmnNombrePelicula.setCellValueFactory(new PropertyValueFactory<VideoClub,String>("plicula"));
		clmnNombreCliente.setCellValueFactory(new PropertyValueFactory<VideoClub,String>("cliente"));
		clmnFechaDevolucion.setCellValueFactory(new PropertyValueFactory<VideoClub,Date>("fechaDevolucion"));*/
		
		
		tblInformacion.getSelectionModel().selectedItemProperty().
				addListener(new ChangeListener<VideoClub>() {

					@Override
					public void changed(
							ObservableValue<? extends VideoClub> arg0,
								VideoClub valorNuevo, VideoClub valorAnterior) {
										btnModificar.setDisable(false);
										btnEliminar.setDisable(false);
									if(valorNuevo != null) {
										btnAgregar.setDisable(true);
										llenarComponentes(valorNuevo);
									}
							
						
					}
					
				}
						
						);;
		
		conexion.cerrarConexion();
		
	}
	
	//RECORDAR AQUI VAN TODOS LOS COMPONENTES QUE SE VAN A MODIFICAR EN UN DADO CASO
	//QUE SE SELECCIONE DEL TABLEVIEW
	public void llenarComponentes(VideoClub valorNuevo) {
		this.txtCodigo.setText(String.valueOf(valorNuevo.getCodigoVenta()));
	}
	
	public void registroNoAgregado() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText("Registro no agregado");
		alert.setTitle("Registro no agregado");
		alert.setHeaderText("resultado");
		alert.showAndWait();
	}
	
	//RECORDAR CORREGIR LOS DATOS FALTANTES EN LA BASE DE DATOS, CONSTRUCTORES ETC
	@FXML
	public void agregar() {
		VideoClub vc = new VideoClub(
					Integer.valueOf(txtCodigo.getText()),
					Integer.valueOf(txtCantidadPeliculas.getText()),
					Integer.valueOf(txtPrecioAlquiler.getText()),
					//recordar crear funcion para calculo de total ( linea de abajo )
					Integer.valueOf(txtTotal.getText()),
					new Cliente(null , txtNombreCliente.getText(),Integer.valueOf( txtIdentidadCliente.getText()),Integer.valueOf(txtTelefono.getText()),Integer.valueOf(txtDemoraLempiras.getText())),
					new Pelicula(null, this.txtNombre.getText(), null, this.txtDescripcion.getText(), null, this.txtEstatus.getText()),
					null ,
					null ,
					null, new Usuario(null , null , null)
				);
		
		
		conexion.establecerConexion();
		vc.guardarRegistro(conexion);
		conexion.cerrarConexion();
	}
	
	@FXML
	public void eliminar() {
		VideoClub vc = new VideoClub(
				Integer.valueOf(txtCodigo.getText()),
				Integer.valueOf(txtCantidadPeliculas.getText()),
				Integer.valueOf(txtPrecioAlquiler.getText()),
				//recordar crear funcion para calculo de total ( linea de abajo )
				Integer.valueOf(txtTotal.getText()),
				new Cliente(null , txtNombreCliente.getText(),Integer.valueOf( txtIdentidadCliente.getText()),Integer.valueOf(txtTelefono.getText()),Integer.valueOf(txtDemoraLempiras.getText())),
				new Pelicula(null, this.txtNombre.getText(), null, this.txtDescripcion.getText(), null, this.txtEstatus.getText()),
				null ,
				null ,
				null, new Usuario(null , null , null)
			);
	
	
	conexion.establecerConexion();
	int resultado = vc.eliminarRegistro(conexion);
	conexion.cerrarConexion();
	}
	
	@FXML
	public void modificar() {
		VideoClub vc = new VideoClub(
				Integer.valueOf(txtCodigo.getText()),
				Integer.valueOf(txtCantidadPeliculas.getText()),
				Integer.valueOf(txtPrecioAlquiler.getText()),
				//recordar crear funcion para calculo de total ( linea de abajo )
				Integer.valueOf(txtTotal.getText()),
				new Cliente(null , txtNombreCliente.getText(),Integer.valueOf( txtIdentidadCliente.getText()),Integer.valueOf(txtTelefono.getText()),Integer.valueOf(txtDemoraLempiras.getText())),
				new Pelicula(null, this.txtNombre.getText(), null, this.txtDescripcion.getText(), null, this.txtEstatus.getText()),
				null ,
				null ,
				null, new Usuario(null , null , null)
			);
	
	
	conexion.establecerConexion();
	int resultado = vc.modificarRegistro(conexion);
	conexion.cerrarConexion();
	}
	
	public void abrirFormulario1() {
		main.abrirFormulario1();
	}
	public void abrirFormulario2() {
		main.abrirFormulario2();
	}
	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	@FXML
	public void Salir() {
		System.exit(0);
	}
	
}
