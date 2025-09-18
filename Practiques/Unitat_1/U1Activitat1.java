/**
 * Autor: Carlos Francés Valdés
 * Descripció: Si que compila.  
 * He tingut problemes al primer printf pero al final funciona be. 
 * Per a la hipotenusa també volia utilitzar printf pero me va donar problemes per amb el Math.sqrt.
 */
import java.util.Scanner;
public class U1Activitat1{
	public static void main(String[] args) {
	
		double radi, baseRectangle, alturaRectangle;
	
		Scanner input = new Scanner(System.in);
		System.out.println("Dis-me el valor del radi d'un cercle: ");
		radi = input.nextDouble();
		System.out.println("Ara dis-me el valor de la base d'un rectangle: ");
		baseRectangle = input.nextDouble();
		System.out.println("No oblides dir-me també el valor de l'altura del rectangle: ");
		alturaRectangle = input.nextDouble();
	
		double pi, perimetre, areaCercle, areaRectangle;

		pi = 3.1416;
		perimetre = (2 * pi)* radi;
		areaCercle = pi * (radi * radi);
		areaRectangle = baseRectangle * alturaRectangle;

		System.out.printf("De moment tenim un cercle de perímetre %.2f i àrea %.2f , i un rectangle d'àrea %.2f \n", perimetre, areaCercle, areaRectangle);

		float catet1, catet2;

		System.out.println("\nM'agrada el teorema de Pitàgores, dis-me el valor del catet 1: ");
		catet1 = input.nextFloat();
		System.out.println("I també del catet 2: ");
		catet2 = input.nextFloat();
		
		float catet1Q, catet2Q, hipotenusaQ;
		catet1Q = catet1*catet1;
		catet2Q = catet2*catet2;
		hipotenusaQ = catet1Q + catet2Q;
		
		double hipotenusa;
		hipotenusa = Math.sqrt(hipotenusaQ);

		System.out.println("D'acord, el valor de la hipotenusa al quadrat és "+ hipotenusaQ +", per tant, el valor de la hipotenusa és "+ hipotenusa);
		
		input.close();
	}
}
	
	
	
	
	
	
	
		
	
