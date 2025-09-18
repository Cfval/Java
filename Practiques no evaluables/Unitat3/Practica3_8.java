
import java.util.Scanner;
public class Practica3_8 {
    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
        
        // creem l entrada per a les columnes y les files. Enters.
        int n, m;

        System.out.println("Quantes files? ");
        n = teclat.nextInt();
        System.out.println("I quantes columnes? ");
        m = teclat.nextInt();

        // creem l'array
        int [][] array = new int[n][m];

        // estructura repetitiva per a sumar el valor de l'element anterior a cada element
        for (int i = 0; i < array.length; i++){
            System.out.print("Index " + i + ":\t");
            for(int j = 0; j < array[i].length; j++){
                array[i][j] = i + j;
                System.out.print(array [i][j] + " ");
            }
            System.out.println();
        }
        teclat.close();
    }
}

