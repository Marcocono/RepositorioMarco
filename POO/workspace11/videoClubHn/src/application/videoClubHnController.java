package application;

import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.VideoClub;

public class videoClubHnController {
	public class videoClubController implements Initializable{
		@FXML private TextField txtCodigo;
		@FXML private TextField txtNombre;
		@FXML private TextArea txtDescripcion;
		
		@FXML private ComboBox<String> cboCategoria;
		@FXML private ComboBox<String> cboEstatus;
		
		@FXML private Button btnAgregar;
		@FXML private Button btnEliminar;
		@FXML private Button btnModificar;
		@FXML private Button btnSalir;
		
		@FXML private DatePicker dpFechaRenta;
		@FXML private DatePicker dpFechaRetorno;
		
		@FXML private RadioButton rbtAlta;
		@FXML private RadioButton rbtBaja;
		
		@FXML private ObservableList<String> listaEstatus;
		@FXML private ObservableList<String> listaCategoria;
		
		@FXML private ObservableList<VideoClub> informacion; 
		
//		@FXML private ListView lstVendedor;
		
		@FXML private TableView<VideoClub> tblInformacion;
		@FXML private TableColumn<VideoClub,Number> clmnCodigoProducto;
		@FXML private TableColumn<VideoClub,String> clmnNombre;
		@FXML private TableColumn<VideoClub,String> clmnDescripcion;
		@FXML private TableColumn<VideoClub,String> clmnCategoria;
		@FXML private TableColumn<VideoClub,String> clmnnVendedor;
		@FXML private TableColumn<VideoClub,Date> clmnFechaRenta;
		@FXML private TableColumn<VideoClub,Date> clmnFechaDevolucion;
		@FXML private TableColumn<VideoClub,String> clmnEstatus;
		@FXML private TableColumn<VideoClub,String> clmnPrioridad;
	
	
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			listaEstatus = FXCollections.observableArrayList();
			listaCategoria = FXCollections.observableArrayList();
			informacion = FXCollections.observableArrayList();
			
			llenarListas();
			cboCategoria.setItems(listaCategoria);
			cboEstatus.setItems(listaEstatus);
			
			clmnCodigoProducto.setCellValueFactory(new PropertyValueFactory<VideoClub,Number>("codigoProducto"));
			clmnNombre.setCellValueFactory(new PropertyValueFactory<VideoClub,String>("nombre"));
			clmnDescripcion.setCellValueFactory(new PropertyValueFactory<VideoClub,String>("descripcion"));
			clmnCategoria.setCellValueFactory(new PropertyValueFactory<VideoClub,String>("categoria"));
			clmnnVendedor.setCellValueFactory(new PropertyValueFactory<VideoClub,String>("vendedor"));
			clmnFechaRenta.setCellValueFactory(new PropertyValueFactory<VideoClub,Date>("fechaRenta"));
			clmnFechaDevolucion.setCellValueFactory(new PropertyValueFactory<VideoClub,Date>("fechaDevolucion"));
			clmnEstatus.setCellValueFactory(new PropertyValueFactory<VideoClub,String>("estatus"));
			clmnPrioridad.setCellValueFactory(new PropertyValueFactory<VideoClub,String>("prioridad"));
			
			tblInformacion.setItems(informacion);
			
			
			tblInformacion.getSelectionModel().
			selectedItemProperty().
			addListener(
						new ChangeListener<VideoClub>() {
						
							public void changed(
									ObservableValue<? extends VideoClub> arg0,
									VideoClub valorAnterio, VideoClub valorNuevo) {
								btnAgregar.setDisable(false);
								btnEliminar.setDisable(false);
								if ( valorNuevo != null ){
									btnAgregar.setDisable(true);
									llenarComponentes(valorNuevo);
								}
							}	
						}		
					);
			
		}
		
		@FXML
		public void llenarComponentes(VideoClub valorNuevo){
			txtCodigo.setText(String.valueOf(valorNuevo.getCodigoProducto()));
			txtNombre.setText(String.valueOf(valorNuevo.getNombre()));
			txtDescripcion.setText(String.valueOf(valorNuevo.getDescripccion()));
			dpFechaRenta.setValue(valorNuevo.getFechaRenta().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
			dpFechaRetorno.setValue(valorNuevo.getFechaDevolucion().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
			cboCategoria.getSelectionModel().select(valorNuevo.getCategoria());
			cboEstatus.getSelectionModel().select(valorNuevo.getEstatus());
			
			if(valorNuevo.getPrioridadAlta().equals("Alta"))
				rbtAlta.setSelected(true);
			else if (valorNuevo.getPrioridadBaja().equals("Baja"))
					rbtBaja.setSelected(true);
				else {
					rbtAlta.setSelected(false);
					rbtBaja.setSelected(false);
				}
		}
		
		@FXML
		public void llenarListas(){
			
			listaCategoria.add("Terror");
			listaCategoria.add("Suspenso");
			listaCategoria.add("Ciencia ficcion");
			listaCategoria.add("Drama");
			listaCategoria.add("Romantica");
			listaCategoria.add("Documental");
			
			
			listaEstatus.add("Alquilada");
			listaEstatus.add("Disponible");
			
		}
		
		@FXML
		public void agregarRegistro(){
			informacion.add( 
					
					new VideoClub(
							Integer.valueOf(txtCodigo.getText()),
							txtNombre.getText(),
							txtDescripcion.getText(),
							cboCategoria.getSelectionModel().getSelectedItem(),
							"",
							new Date(dpFechaRenta.getValue().toEpochDay()),
							new Date(dpFechaRetorno.getValue().toEpochDay()),
							cboEstatus.getSelectionModel().getSelectedItem(),
							rbtAlta.isSelected()?rbtAlta.getText():rbtBaja.getText(),
							" "
							)
					
					);
			
		}
		
		
		@FXML
		public void actualizarRegistro(){
			informacion.set(tblInformacion.getSelectionModel().getSelectedIndex(), 
					new VideoClub(
							Integer.valueOf(txtCodigo.getText()),
							txtNombre.getText(),
							txtDescripcion.getText(),
							cboCategoria.getSelectionModel().getSelectedItem(),
							"",
							new Date(dpFechaRenta.getValue().toEpochDay()),
							new Date(dpFechaRetorno.getValue().toEpochDay()),
							cboEstatus.getSelectionModel().getSelectedItem(),
							rbtAlta.isSelected()?rbtAlta.getText():rbtBaja.getText(),
							" "
							));
			
		}
		
		@FXML
		public void eliminarRegistro(){
			Alert cuadroDialogo = new Alert(AlertType.CONFIRMATION);
			cuadroDialogo.setTitle("Confirmacion");
			cuadroDialogo.setHeaderText("Eliminar registro");
			cuadroDialogo.setContentText("¿Esta seguro que desea eliminar este registro?");
			Optional<ButtonType> resultado = cuadroDialogo.showAndWait();
			if(resultado.get() == ButtonType.OK)
				informacion.remove(tblInformacion.getSelectionModel().getSelectedIndex());
				limpiarComponentes();
				Alert cuadroDialogo1 = new Alert(AlertType.INFORMATION);
				cuadroDialogo1.setContentText("Registro eliminado con exito");
				cuadroDialogo1.setTitle("Registro Eliminado");
				cuadroDialogo1.setHeaderText("Resultado:");
				cuadroDialogo1.showAndWait();
		}
		
		@FXML
		public void limpiarComponentes(){
			txtNombre.setText(null);
			txtCodigo.setText(null);
			txtDescripcion.setText(null);
			this.cboCategoria.getSelectionModel().select(null);
			this.cboEstatus.getSelectionModel().select(null);
			this.dpFechaRenta.setValue(null);
			this.dpFechaRetorno.setValue(null);
			this.rbtAlta.setSelected(false);
			this.rbtBaja.setSelected(false);
			
			btnAgregar.setDisable(true);
			btnModificar.setDisable(true);
			btnEliminar.setDisable(true);
		}
		
		@FXML
		public void Salir(){
			System.exit(0);
		}
	
	}
}
