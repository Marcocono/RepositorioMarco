package Formulario;

import javafx.fxml.FXML;

public class Formulario2Controller {
	private Main main;

	
	public Formulario2Controller(){
		
	}
	
	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}
	
	@FXML public void abrirFormulario2(){
		main.abrirFormulario2();
	}
	
	
}
