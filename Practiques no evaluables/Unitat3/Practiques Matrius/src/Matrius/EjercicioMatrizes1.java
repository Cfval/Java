package Matrius;

import java.util.Scanner;

public class EjercicioMatrizes1 {
    public static void main(String[] args) {
        
        Scanner teclat =  new Scanner(System.in);
        
        System.out.println("Escriu un tamany: ");
        int tamany = teclat.nextInt();             // temany de la matriu 

        int matriu1 [][] = new int[tamany][tamany];
        int matriu2 [][] = new int[tamany][tamany];

        int resultat [][] = new int[tamany][tamany];   // per a guardar el valor de la suma de les dos matrius

        
        for (int i = 0; i<matriu1.length; i++){
            for(int j = 0; j<matriu1[0].length; j++){

                //Rellenar els valors per teclat
                System.out.println("Escriu el valor per a la fila "+i+" y columna "+j+" de la matriu 1");
                matriu1[i][j] = teclat.nextInt();   

                System.out.println("Escriu el valor per a la fila "+i+" y columna "+j+" de la matriu 2");
                matriu2[i][j] = teclat.nextInt();

                //Guardem la suma de les matrius
                resultat[i][j] = matriu1[i][j] + matriu2 [i][j];
            }
        }

        System.out.println("Matriu 1: ");
        mostraMatriu(matriu1);

        System.out.println("Matriu 2: ");
        mostraMatriu(matriu2);

        System.out.println("Matriu resultant: ");
        mostraMatriu(resultat);

        teclat.close();
        
    } 

    //Funció per a recorrer y mostrar una matriu
    public static void mostraMatriu(int[][] matriu){  
        for(int i = 0;i<matriu.length;i++){
            for(int j = 0;j<matriu[0].length; j ++){
                System.out.print(matriu[i][j]+" ");
            }
            System.out.println("");
        }
    }

}