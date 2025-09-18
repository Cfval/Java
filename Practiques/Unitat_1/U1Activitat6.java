/**
 * Autor: Carlos Francés Valdés
 * Descripció: Si que compila. He tingut que buscar informació perque no estic acostumat a aquestes operacións matemátiques.
 */
import java.util.Scanner;
public class U1Activitat6{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int preu, diners, canvi,moneda50, moneda20, moneda10, moneda5, moneda2, moneda1;
		
		System.out.println("-MAQUINA DE BEGUDES- \n------------------");
		
		System.out.println("Introdueix el preu de la beguda que vols: ");
		preu = input.nextInt();
		
		System.out.println("Diners que introdueixes a la mèquina en cèntims(màxim 100): ");
		diners = input.nextInt();
		
		canvi = diners - preu;
		System.out.println("El seu canvi és: "+ canvi +"cèntims");
	 	
		moneda50 = canvi / 50;
		moneda20 = (canvi % 50) / 20;
		moneda10 = ((canvi % 50) % 20) / 10;
		moneda5 = (((canvi % 50) % 20) % 10) / 5;
		moneda2 = ((((canvi % 50) % 20) % 10) % 5) / 2;
		moneda1 = ((((canvi % 50) % 20) % 10) % 5) % 2;

		System.out.println("La quantitat de monedes de 50 cèntims és: " + moneda50);
        	System.out.println("La quantitat de monedes de 20 cèntims és: " + moneda20);
        	System.out.println("La quantitat de monedes de 10 cèntims és: " + moneda10);
        	System.out.println("La quantitat de monedes de 5 cèntims és: " + moneda5);
        	System.out.println("La quantitat de monedes de 2 cèntims és: " + moneda2);
        	System.out.println("La quantitat de monedes d'1 cèntim és: " + moneda1);

			input.close();
	}
}
	
	
	
	
	
	
	
		
	
		
	