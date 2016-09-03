package Formulario;

import javafx.fxml.FXML;

public class Formulario3Controller {
	private Main main;

	
	public Formulario3Controller(){
		
	}
	
	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}
	
	@FXML public void abrirFormulario3(){
		main.abrirFormulario3();
	}
	
}
