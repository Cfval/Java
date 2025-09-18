/**
 * Autor: Carlos Francés Valdés
 * Descripció: Si que compila. Segur que hi ha millor manera de fer les operacións, pero esta es la que se me ocorre a mi.  
 */
public class U1Activitat2{
	public static void main(String[] args) {
		final int any;
		int naixements, morts, immigrants, poblacioActual;
		any = 365*24*60*60;
		naixements = any/7;
		morts = any/13;
		immigrants = any/7;
		poblacioActual = 312032486;
		
		
		System.out.println("La població actual es de " + poblacioActual + " y els cinc próxims anys será de:");
		poblacioActual = poblacioActual + naixements + immigrants - morts;
		System.out.println("Any 2024: " + poblacioActual);
		poblacioActual = poblacioActual + naixements + immigrants - morts;
		System.out.println("Any 2025: " + poblacioActual);
		poblacioActual = poblacioActual + naixements + immigrants - morts;
		System.out.println("Any 2026: " + poblacioActual);
		poblacioActual = poblacioActual + naixements + immigrants - morts;
		System.out.println("Any 2027: " + poblacioActual);
		poblacioActual = poblacioActual + naixements + immigrants - morts;
		System.out.println("Any 2028: " + poblacioActual);
		 
	}
}
	
	
	
	
	
	
	
		
	
