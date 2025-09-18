package itv;

public class ColaInicial {

	private Vehiculo vehiculos[];
	private int contador;
	
	ColaInicial(){
		vehiculos=new Vehiculo[100];
		contador=0;
		
		for (int i=0; i<100; i++)
			vehiculos[i]=null;
	}
	
	
	
	public void anyadir(Vehiculo pveh) {
		vehiculos[contador]=pveh;
		contador++;
	}
	
	
	
	public Vehiculo extraer() {
		Vehiculo aux=vehiculos[contador];
		
		vehiculos[contador]=null;
		contador--;
		
		return aux;
	}
	
	
	
	public boolean estaVacia() {
		boolean aux= false;
		
		if (contador==0)
			aux=true;
		
		return aux;
	}
	
	
	
	public void mostrar() {
		
	}
	
	
	public boolean contieneMatricula(String pmat) {
		boolean aux= false;
		
		for (int i=0; i<100 && !aux; i++)
			if(pmat.equals(vehiculos[i].getMatricula()))
				aux=true;
		
		return aux;
	}
	
	
}
