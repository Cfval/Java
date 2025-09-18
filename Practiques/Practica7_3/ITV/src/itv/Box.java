package itv;

public class Box {

	private int id;
	private FaseRevision fasesRevision[];
	private static final String TITULOS_FASES[]= {"Seguridad", "Sistema Electrico", "Emision de humos","Frenos"};
	private static final int NUM_FASES=4;
	
	Box(int pid) {
		id=pid;
		fasesRevision=new FaseRevision[4];
		
		for(int i=0; i<4; i++)
			fasesRevision[i]=null;
	}
	
	public boolean estaLibre() {
		boolean aux = false;
		
		
		return aux;
	}
	
	
	public boolean esPrimeraFase(int indexFase) {
		boolean aux = false;
		
		if(indexFase==0)
			aux=true;
		
		return aux;
	}
	
	
	public void anyadir(Vehiculo pveh) {
		
	}
	
	
	public void pasarVehiculosDeFase() {
		
	}
	
	
	public void mostrar() {
		
	}
}
