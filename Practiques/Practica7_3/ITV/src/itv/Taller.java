package itv;

public class Taller {

	private Box boxs[];
	private ColaInicial colaIni;
	private static final int NUM_BOXS=6;
	
	Taller() {
		boxs=new Box[NUM_BOXS];
		colaIni=new ColaInicial();
		
		for(int i=0; i<NUM_BOXS; i++)
			boxs[i]=null;
	}
	
	
	
	
	public Vehiculo recogerNuevoVehiculo() {
		Vehiculo aux=null;
		
		return aux;
	}
	
	public String leerMatricula() {
		String aux="";
		
		return aux;
	}
	
	
	public String leerModelo() {
		String aux="";
		
		return aux;
	}
	
	
	public TipoVehiculo leerTipoVehiculo() {
		TipoVehiculo aux=null;
		
		return aux;
	}
	
	
	public static void main(String[] args) {
		Taller taller=new Taller();
		
		taller.iniciar();
	}
	
	
	public void iniciar() {
		int opcion=0;
		String matri="";
		String mod="";
		TipoVehiculo miveh=TipoVehiculo.COCHE;
		
		Vehiculo myVehiculo=null;
		
		boolean eixir=false;
		
		Menu myMenu=new Menu();
		//myMenu.mostrar();
		
		do {
			myMenu.mostrar();
			opcion=myMenu.leerOpcion();
			
			switch(opcion) {
				case 1:
					matri=leerMatricula();
					mod=leerModelo();
					miveh=leerTipoVehiculo();
					myVehiculo=new Vehiculo(matri, mod, miveh);
					myVehiculo=new Vehiculo(leerMatricula(), leerModelo(), leerTipoVehiculo());
					
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				
				case 6:
					System.out.println("Adeu, gracies.");
					eixir=true;
					break;
			}
		}while(!eixir);
		
		System.out.println(opcion);
	}
	
}
