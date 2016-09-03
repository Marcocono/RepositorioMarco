package Formulario;


public class FormularioPrincipalController {
	private Main main;

	public FormularioPrincipalController(){
	}
	
	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}
	
	public void abrirFormulario1() {
		main.abrirFormulario1();
	}
	
	public void abrirFormulario2() {
		main.abrirFormulario2();
	}
	
	public void Salir() {
		System.exit(0);
	}
}
