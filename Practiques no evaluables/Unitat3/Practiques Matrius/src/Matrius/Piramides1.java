package Matrius;
import java.util.Scanner;
/**
 * @author atataP
 */
public class Piramides1 {

    public static void main(String args[]) {
        Scanner teclat = new Scanner(System.in);
        int n, m;
        
        System.out.println("Intruduix numero de files: ");
        while(!teclat.hasNextInt() || (n = teclat.nextInt()) < 1){
            teclat.nextLine();
            System.out.println("Error. Torna a intentar: ");
        }
        teclat.nextLine();
        
        // en este em de añadir || m % 2 == 0 per a comprovar que siga impar
        System.out.println("Intruduix numero de columnes impar: ");
        while(!teclat.hasNextInt() || (m = teclat.nextInt()) < 1 || m % 2 == 0){
            teclat.nextLine();
            System.out.println("Error. Torna a intentar: ");
        }
        teclat.nextLine();
        
        char[][] a = new char[n][m];
        int mitad = a[0].length / 2;
        
        for(int i = 0; i<a.length ;i++){
            for (int j = 0; j<a[i].length; j++){
            
                if((i+j) >= mitad && (j-i) <= mitad){
                   a[i][j] = '*'; 
                }else {
                   a[i][j] = ' ';
                }
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
