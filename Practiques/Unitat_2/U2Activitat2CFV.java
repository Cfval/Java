/**
 * Autor: Carlos Francés Valdés
 * Descripció: No he sigut capaç de ficar ho tot dins de un bucle. He tingut problemes amb el scanner.hasNextInt pero els he pogut solucionar.
 * Compila y fucniona be.
 */
import java.util.Scanner;
public class U2Activitat2CFV{
	public static void main(String[] args) { 
		Scanner scanner = new Scanner(System.in);
		boolean joc;
		int numAleatori, numIntents, numIntroduit, contadorIntents, diferencia;
		System.out.println("BENVINGUT AL JOC: ENDEVINA EÑ NUMERO SECRET\n"+"--------------------------------------------------");
		
		numIntents = 0;
		contadorIntents = 1;
		numIntroduit = 0;
		numAleatori = (int) (Math.random() * 100) + 1;
		joc = false;
		
		do {
			System.out.println("De cuants intents vols disposar?: ");
			if(scanner.hasNextInt()){
				numIntents = scanner.nextInt();
			
				if (numIntents > 0 && numIntents < 11 ){ 
				joc = true;
				} else {
				System.out.println("ERROR\n");
				}
			} else {
				System.out.println("ERROR\n");
				scanner.next();
			}
		} while(!joc);
		
		while (joc && numAleatori != numIntroduit && numIntents > 0 ){
			
			do {
				System.out.println("Intent " + contadorIntents + ":");
				if (scanner.hasNextInt()){ 
					numIntroduit = scanner.nextInt();
					
					if (numIntroduit >= 0 && numIntroduit < 100 ){
					joc = true;
					} else {
					System.out.println("ERROR\n");
					contadorIntents--;
					numIntents++;
					} 
				} else {
					System.out.println("ERROR\n");
					scanner.next();
					contadorIntents--;
					numIntents++;
				}
			} while(!joc);
			
			diferencia = Math.abs(numAleatori - numIntroduit);
			
			if (diferencia > 29 && numIntroduit > numAleatori){
				System.out.println("El número introduit és menor (fred)");
			} else if (diferencia > 29 && numIntroduit < numAleatori){
				System.out.println("El número introduit és més gran (fred)");
			} else if (diferencia >= 10 && numIntroduit > numAleatori){
				System.out.println("El número introduit és menor (temperat)");
			} else if (diferencia >= 10 && numIntroduit < numAleatori){
				System.out.println("El número introduit és més gran (temperat)");
			} else if (diferencia < 10 && numIntroduit > numAleatori){
				System.out.println("El número introduit és menor (calent)");
			} else if (diferencia < 10 && numIntroduit < numAleatori){
				System.out.println("El número introduit és més gran (calent)");
			} else {
				System.out.println("Enhorabona, has encertat el número");
			}
				
			
			contadorIntents++;
			numIntents--;
		}
			
		
		if (numIntents == 0 && numAleatori != numIntroduit) {
			System.out.println("\nHas perdut, el número era " + numAleatori);
		}
		
		scanner.close();
		
	}
}