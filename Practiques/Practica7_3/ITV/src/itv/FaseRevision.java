package itv;

public class FaseRevision {
	
	private String nombre;
	private Vehiculo vehiculo;
	
	
	FaseRevision(String pnom) {
		nombre=pnom;
		vehiculo=null;
	}
	
	
	public boolean tieneVehiculo() {
		boolean aux=true;
		
		if (this.vehiculo==null)
			aux=false;
		
		return aux; 
	}
	
	
	
	
	public void asignarVehiculo(Vehiculo pveh) {
		this.vehiculo=pveh;
	}
	
	
	
	
	public void desasignarVehiculo() {
		this.vehiculo=null;
	}
	
	
	
	
	public void mostrar() {
		if(this.vehiculo==null)
			System.out.println("Fase "+this.nombre + " sin vehiculo.");
		else
			System.out.println("Fase "+this.nombre + " con el vehiculo "+vehiculo.toString());
	}
	
	
	
	public void AsignarVehiculoA(FaseRevision pfas) {
		this.nombre=pfas.nombre;
		this.vehiculo=pfas.vehiculo;
		
	}
}
