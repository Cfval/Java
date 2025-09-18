package Matrius;
import java.util.Scanner;
/**
 * @author atataP
 */
public class Piramides3 {

    public static void main(String args[]) {
    
        Scanner teclat = new Scanner(System.in);
      
        int n, m;
        
        System.out.println("Intruduix numero de files: ");
        while(!teclat.hasNextInt() || (n = teclat.nextInt()) < 1){
            teclat.nextLine();
            System.out.println("Error. Torna a intentar: ");
        }
        teclat.nextLine();
        
        System.out.println("Intruduix numero de columnes: ");
        while(!teclat.hasNextInt() || (m = teclat.nextInt()) < 1){
            teclat.nextLine();
            System.out.println("Error. Torna a intentar: ");
        }
        teclat.nextLine();
        
        char[][] piramide = new char[n][m];
        
        /*podem jugar amb el valor de m(llargaria de les columnes)
        * per a fer canvis en la piramide. Ara esta completa.
        */
        for(int i=0;i<piramide.length;i++){
            
            for(int j=0;j<piramide[i].length;j++){
                
                if(j >= (m - 1)){ // m - 1 ens dona la posició en l'array de l ultim valor
                    piramide[i][j] = '*';
                }else {
                    piramide[i][j] = ' ';
                }
                System.out.print(piramide[i][j] + " ");
            }
            m--;
            System.out.println();
        }
    }
}
