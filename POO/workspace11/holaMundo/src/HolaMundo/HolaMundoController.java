package HolaMundo;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HolaMundoController {
	@FXML private TextField txtnombre;
	@FXML private Label lblMensaje;
	
	@FXML
	public void accionHolaMundo(){

	}
	
	@FXML
	public void salir(){
		System.exit(0);
	}
}
