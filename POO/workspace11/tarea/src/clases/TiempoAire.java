package clases;

import java.util.Date;

import javax.swing.JOptionPane;

public class TiempoAire extends Paquete {
	private int MinNormales;
	private int MinPromocionales;
	private int MinLlamadasInter;
	private String errores;
	
	public TiempoAire(){
		super();
	
	}
	
	public void ingresarDatos(TiempoAire tiempoAire){
		costo = Integer.valueOf(JOptionPane.showInputDialog("Costo del paquete",super.getCosto()));
		MinNormales = Integer.valueOf(JOptionPane.showInputDialog("Minutos disponibles:"));
		MinPromocionales = Integer.valueOf(JOptionPane.showInputDialog("Saldo promocional:"));
		MinLlamadasInter= Integer.valueOf(JOptionPane.showInputDialog("Minutos internacionales:"));
	}
	
	public TiempoAire(int costo, Date fechaAdquisicion, int minNormales,
			int minPromocionales, int minLlamadasInter) {
		super(costo, fechaAdquisicion);
		MinNormales = minNormales;
		MinPromocionales = minPromocionales;
		MinLlamadasInter = minLlamadasInter;
	}

	public String validarDatos(){
	    if(MinNormales==0)
		    errores+="Ingrese los Minutos normales.\n";
		if(MinPromocionales==0)
			errores+="Ingrese los minutos promocionales.\n";
		if(MinLlamadasInter ==0)
		    errores+="Ingrese los minutos internacionales.\n";
		return errores;
	}
	
	@Override
	protected float Total() {
		//SUMA DE MINUTOS TIEMPO AIRE
		return (MinNormales+ MinPromocionales +MinLlamadasInter);
	}

	public int getMinNormales() {
		return MinNormales;
	}

	public void setMinNormales(int minNormales) {
		MinNormales = minNormales;
	}

	public int getMinPromocionales() {
		return MinPromocionales;
	}

	public void setMinPromocionales(int minPromocionales) {
		MinPromocionales = minPromocionales;
	}

	public int getMinLlamadasInter() {
		return MinLlamadasInter;
	}

	public void setMinLlamadasInter(int minLlamadasInter) {
		MinLlamadasInter = minLlamadasInter;
	}

	@Override
	public String toString() {
		return "\t\t" +  this.getMinLlamadasInter()+ "\t\t"
				+ this.getMinNormales() + "\t\t" + this.getMinPromocionales()
				+ Total();
	}


	
}
