package Matrius;
import java.util.Scanner;
/**
 *
 * @author atataP
 */
public class RepasExamen2 {

    public static void main(String args[]) {
        
        Scanner teclat = new Scanner(System.in);  
        int n = 0;
        
        System.out.println("Escriu un enter: ");
        
        while (!teclat.hasNextInt() || (n = teclat.nextInt()) < 1){
            teclat.nextLine();
            System.out.print("error. intrudueix un enter: ");
        }
        teclat.nextLine();
        
        //array per a recorrer el numero introduit
        for(int i = 0; i < n; i++){
            
            /*si el resto de "i" es 0 entra en el if sino fara l'else
            en cadascu hi ha un bucle per a fer una linea o una altra
            esta: +-+-+ o esta: -+-+-
            */
            if( i % 2 == 0){
                for(int j = 0; j < n; j++){
                    if( j % 2 == 0){            //tornem a comprovar si el resto es 0 per a fer una cosa o un altra
                        System.out.print("+ ");
                    } else {
                        System.out.print("- ");
                    }
                }
            }else {
                for(int j = 0; j < n; j++){
                    if( j % 2 == 0){
                        System.out.print("- ");
                    } else {
                        System.out.print("+ ");
                    }
                }
            }
            System.out.println();
        }
        teclat.close();
    }
}
