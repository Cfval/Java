package itv;

public class Vehiculo {

	private String matricula;
	private String modelo;
	private TipoVehiculo tipoVehiculo;
	public static final String PATRON_MATRICULA = "\\D{4}[A-Z]{3}";
	
	Vehiculo(String pmat, String pmod, TipoVehiculo pTip) {
		matricula=pmat;
		modelo=pmod;
		tipoVehiculo=pTip;
	}
	
	public boolean tieneEsta(String matricula) {
		boolean aux=false;
		
		return aux;
	}
	
	
	public String getMatricula() {
		return this.matricula;
	}
	
	
	public TipoVehiculo tiposSegunIndex(int pindice) {
		return tipoVehiculo;
	}
	
	
	public String toString() {
		return "coche";
	}
}
