package Matrius;
import java.util.Scanner;
/**
 * @author atataP
 */
public class RepasExamen3 {

    public static void main(String args[]) {
        Scanner teclat = new Scanner(System.in);
        int n = 0;
        int valorConsecutiu = 1;
        
        System.out.println("Introdueix un enter: ");
        while(!teclat.hasNextInt() || (n = teclat.nextInt()) < 0){
            teclat.nextLine();
            System.out.println("Error, introduix un enter: ");   
        }
        teclat.nextLine();
        
        int[][] array =  new int[n][n];
        
        for(int i = 0;i < array.length;i++){
            
            for(int j = 0;j < array[i].length;j++){
                //valorConsecutiu += 1; (hi hauria que ficar valorConsecutiu = 0 al declarar)
                array[i][j] = valorConsecutiu++; //fiquem valorConsecutiu = 1 al declarar
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        teclat.close();
    }
}
