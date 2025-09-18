package itv;
import itv.util.GestorIO;
import itv.util.Interval;

public class Menu {

	private static final String TITULOS[]= {	"1.-Alta y recepción de vehiculos",
												"2.-Reclamar vehiculo para entrada al box",
												"3.-Mover todos los vehiculos de fase dentro de un box",
												"4.-Información del estado de un box concreto",
												"5.-Información general de todos los boxes",
												"6.-Salir del programa"};
	private static final Interval OPCIONES=new Interval(1,6);
	
	
	public void mostrar() {
		System.out.println("Menú:");
		
		for(int i=0; i<6; i++)
			System.out.println(TITULOS[i]);
		
		System.out.print("Selecciona una opcion: ");
	}
	
	public int leerOpcion() {
		int aux=0;
		GestorIO teclat=new GestorIO();
		
		do {
			aux=teclat.inInt();
			if(!OPCIONES.inclou(aux))
				System.out.print("Error con el valor insertado. Selecciona una opcion: ");
		}while(!OPCIONES.inclou(aux));
			
		return aux;
	}
}
