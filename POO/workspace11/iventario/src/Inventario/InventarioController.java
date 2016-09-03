package Inventario;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class InventarioController implements Initializable {
	
	@FXML private ComboBox cboMarca;
	@FXML private TextField txtCodigoProducto;
	@FXML private TextField txtCodigoBarra;
	@FXML private TextField txtNombreProducto;
	@FXML private TextField txtPrecioVenta;
	@FXML private TextField txtPrecioCompra;
	@FXML private TextArea txtDescripcionProducto;
	
	
	
	private ObservableList<String> listaMarcas;
	//NOTIFICA A LA GUI CUANDO HAY CAMBIO EN LA INFORMACION
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// SE ESTA SEGYURO DE QUE LOS COMPONENTES D ELA GUI ESTAN INSTANCIADOS
		listaMarcas = FXCollections.observableArrayList();
		
		listaMarcas.add(null);
		
		cboMarca.setItems(listaMarcas);
		
	}
}
