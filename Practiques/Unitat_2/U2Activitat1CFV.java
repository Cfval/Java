/**
 * Autor: Carlos Francés Valdés
 * Descripció: Compila y funciona com deuria.
 */
import java.util.Scanner;
public class U2Activitat1CFV{
	public static void main(String[] args) {
		int contador = 0;
		float souMensual, souAnual, impostos;
		impostos = 0;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Introdueix el sou brut mensual(€): ");
		souMensual = input.nextFloat();
		souAnual = souMensual*12;
		
		if (souAnual <= 0){
			System.out.println("ERROR"); 
		}
		while (souAnual > 0 && contador < 1) {
			System.out.println("El teu sou anual és "+ souAnual +"€");
			
			if (souAnual > 0 && souAnual < 10000) {
	
				System.out.println("Et toca pagar "+ impostos +"€ y reps una ajuda de 1500€");
				
			} else if (souAnual >= 10000 && souAnual <= 15000){
				impostos = 0.20f * souAnual;
				
				System.out.println("Et toca pagar "+ impostos +"€ y reps una ajuda de 1500€");
				
			} else if (souAnual >= 15000 && souAnual <= 40000){
				impostos = 0.20f * souAnual;
				
				System.out.println("Et toca pagar "+ impostos +"€ y no reps cap ajuda");
				
			} else if (souAnual > 40000){
				impostos = 0.30f * souAnual;
				
				System.out.println("Et toca pagar "+ impostos +"€ y no reps cap ajuda");
				
			} else {	
			}
			contador++;
		}	
		
		input.close();
	}
}