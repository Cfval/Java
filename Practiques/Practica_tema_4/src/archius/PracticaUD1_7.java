package archius;
import java.util.Scanner;
/**
 *
 * @author Cfval
 */
public class PracticaUD1_7 {
    
    public static void main(String args[]) {
        
        Scanner teclat = new Scanner(System.in);
        
        System.out.println("Escriu un enter: ");
        int n = teclat.nextInt();
        
        for(int i= 1; i<=n ;i++){
           
           System.out.println("\nTabla del " + i + "\n----------"); 
           
           for (int j = 1; j<=10 ;j++){
               
               int resultat = i * j;
               System.out.println(i + " * " + j + " = " + resultat);
           }
        }
        
        
    }
}
