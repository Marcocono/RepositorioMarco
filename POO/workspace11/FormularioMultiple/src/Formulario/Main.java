package Formulario;
	
import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	// CONTROLADORES
	private FormularioPrincipalController formularioPrincipalController;
	private Formulario1Controller formulario1Controller;
	private Formulario2Controller formulario2Controller;
	private Formulario3Controller formulario3Controller;
	
	//FORMULARIOS
	private Stage formulario1;
	private Stage formulario2;
	private Stage formulario3;
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			//PERMITE TENER LA REFERENCIA DEL CONTROLADOR Y PERMITE OBTENER
			//LA INSTANCIA A LA CUAL ESTA RELACIONADO ESA VISTA
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("Formulario1.fxml"));
			BorderPane root = (BorderPane)loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			formularioPrincipalController  = loader.getController();
			formularioPrincipalController.setMain(this);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void abrirFormulario1(){
		
		if(formulario1 == null) {
				try {
					
					//PERMITE TENER LA REFERENCIA DEL CONTROLADOR Y PERMITE OBTENER
					//LA INSTANCIA A LA CUAL ESTA RELACIONADO ESA VISTA
					FXMLLoader loader = new FXMLLoader();
					formulario1 = new Stage();
					loader.setLocation(getClass().getResource("Formulario2.fxml"));
					AnchorPane root = (AnchorPane)loader.load();
					Scene scene = new Scene(root);
					//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					formulario1.setScene(scene);
					formulario1Controller  = loader.getController();
					formulario1Controller.setMain(this);
					formulario1.show();
				} catch(Exception e) {
					e.printStackTrace();
				}
		}else {
			formulario1.show();
		}
	}
	
	public void abrirFormulario2(){
		
		if(formulario2 == null) {
				try {
						
						//PERMITE TENER LA REFERENCIA DEL CONTROLADOR Y PERMITE OBTENER
						//LA INSTANCIA A LA CUAL ESTA RELACIONADO ESA VISTA
						FXMLLoader loader = new FXMLLoader();
						formulario2 = new Stage();
						loader.setLocation(getClass().getResource("Formulario2.fxml"));
						AnchorPane root = (AnchorPane)loader.load();
						Scene scene = new Scene(root);
						//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						formulario2.setScene(scene);
						formulario2Controller  = loader.getController();
						formulario2Controller.setMain(this);
						formulario2.show();
					} catch(Exception e) {
						e.printStackTrace();
					}
		}else {
			formulario2.show();
		}
	}
	
public void abrirFormulario3(){
		
		if(formulario3 == null) {
				try {
						
						//PERMITE TENER LA REFERENCIA DEL CONTROLADOR Y PERMITE OBTENER
						//LA INSTANCIA A LA CUAL ESTA RELACIONADO ESA VISTA
						FXMLLoader loader = new FXMLLoader();
						formulario3 = new Stage();
						loader.setLocation(getClass().getResource("Formulario3.fxml"));
						AnchorPane root = (AnchorPane)loader.load();
						Scene scene = new Scene(root);
						//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						formulario3.setScene(scene);
						formulario3Controller  = loader.getController();
						formulario3Controller.setMain(this);
						formulario3.show();
						formulario3.initOwner(formulario1);
						formulario3.initModality(Modality.WINDOW_MODAL);
					} catch(Exception e) {
						e.printStackTrace();
					}
		}else {
			formulario2.show();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
