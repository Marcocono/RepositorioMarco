package clases;

import java.util.Date;

public abstract class  Paquete {
	protected int costo;
	protected Date fechaAdquisicion;
	
	public Paquete(){
		
	}
	public Paquete(int costo, Date fechaAdquisicion) {
		super();
		this.costo = costo;
		this.fechaAdquisicion = fechaAdquisicion;
	}
	
	protected abstract float Total();
	public int getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo = costo;
	}
	public Date getFechaAdquisicion() {
		return fechaAdquisicion;
	}
	public void setFechaAdquisicion(Date fechaAdquisicion) {
		this.fechaAdquisicion = fechaAdquisicion;
	}
}
