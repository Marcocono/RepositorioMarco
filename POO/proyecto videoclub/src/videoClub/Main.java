package videoClub;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	//CONTROLADORES
	private VideoClubController videoClubController;
	private Formulario1Controller formulario1Controller;
	private Formulario2Controller formulario2Controller;
	private FormularioContenedorController formularioContenedorController;
	
	//FORMULARIOS
	private Stage formularioContenedor;
	private Stage formulario1;
	private Stage formulario2;
	private Stage formularioVideoClub;
	
	@Override
	public void start(Stage primaryStage) {
		formularioContenedor = primaryStage;
		
		try {
			FXMLLoader load = new FXMLLoader();
			load.setLocation(getClass().getResource("FormularioContenedor.fxml"));
			AnchorPane root = (AnchorPane)load.load();
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			primaryStage.setTitle("Video Club");
			primaryStage.resizableProperty();
			formularioContenedorController = load.getController();
			formularioContenedorController.setMain(this);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void abrirFormularioVideoClub() {
		
	}
	
	public void abrirFormulario1() {
		if(formulario1==null) {
			formulario1 = new Stage();
			formulario1.setTitle("Formulario1");
			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("Formulario1.fxml"));
				AnchorPane root = (AnchorPane)loader.load();
				
				Scene scene = new Scene(root);
				formulario1.setScene(scene);
				formulario1Controller = loader.getController();
				formulario1Controller.setMain(this);
				
				formulario1.initOwner(formularioContenedor);
				formulario1.initModality(Modality.WINDOW_MODAL);
				
				formulario1.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			formulario1.show();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("El formulario 1 ya esta abierto");
			alert.setHeaderText("Formulario1");
			alert.showAndWait();
		}
	}
	
	
	public void abrirFormulario2() {

		if(formulario2==null) {
			formulario2 = new Stage();
			formulario2.setTitle("Formulario2");
			try {
				
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("Formulario2.fxml"));
				AnchorPane root = (AnchorPane)loader.load();
				Scene scene = new Scene(root);
				formulario2.setScene(scene);
				formulario2Controller = loader.getController();
				formulario2Controller.setMain(this);
				
				formulario2.initOwner(formularioContenedor);
				formulario2.initModality(Modality.WINDOW_MODAL);
				formulario2.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void cerrarFormulario1() {
		formulario1.close();
	}
	
}
