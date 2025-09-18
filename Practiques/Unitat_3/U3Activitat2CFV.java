/**
 * Autor: Carlos Francés Valdés
 * Descripció: Fa la matriu be pero no funciona com deuria
 * Compila 
 */
import java.util.Scanner;

public class U3Activitat2CFV {
    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);

        System.out.print("Introdueix la dimensió de la matriu: ");
        int dimensio = teclat.nextInt();

        int[][] matriu = new int[dimensio][dimensio];
        for (int i = 0; i < dimensio; i++) {
            for (int j = 0; j < dimensio; j++) {
                matriu[i][j] = (int) (Math.random() * 2);
            }
        }

        System.out.println("Matriu generada:");
        for (int i = 0; i < dimensio; i++) {
            for (int j = 0; j < dimensio; j++) {
                System.out.print(matriu[i][j]);
            }
            System.out.println();
        }

        int[] filesAmbMesUns = new int[dimensio];
        int[] columnesAmbMesUns = new int[dimensio];
        int[] filesAmbTotZeros = new int[dimensio];
        int[] filesAmbTotUns = new int[dimensio];
        int[] columnesAmbTotZeros = new int[dimensio];
        int[] columnesAmbTotUns = new int[dimensio];


        for (int i = 0; i < dimensio; i++) {
            int unsEnFila = 0;
            int unsEnColumna = 0;

            for (int j = 0; j < dimensio; j++) {
                unsEnFila += matriu[i][j];
                unsEnColumna += matriu[j][i];
            }

            filesAmbMesUns[i] = unsEnFila;
            columnesAmbMesUns[i] = unsEnColumna;

            if (unsEnFila == 0) {
                filesAmbTotZeros[i] = 1;
            } else if (unsEnFila == dimensio) {
                filesAmbTotUns[i] = 1;
            }

            if (unsEnColumna == 0) {
                columnesAmbTotZeros[i] = 1;
            } else if (unsEnColumna == dimensio) {
                columnesAmbTotUns[i] = 1;
            }
        }

        for (int i = 0; i < dimensio; i++) {
            if (filesAmbMesUns[i] > 0) {
                System.out.println("Fila " + i + " amb major nombre d'uns");
            }
        }

        for (int i = 0; i < dimensio; i++) {
            if (columnesAmbMesUns[i] > 0) {
                System.out.println("Columna " + i + " amb major nombre d'uns");
            }
        }

        for (int i = 0; i < dimensio; i++) {
            if (filesAmbTotZeros[i] > 0) {
                System.out.println("Fila " + i + " amb tot zeros");
            }
        }

        for (int i = 0; i < dimensio; i++) {
            if (filesAmbTotUns[i] > 0) {
                System.out.println("Fila " + i + " amb tot uns");
            }
        }

        boolean diagonalMajorIguals = true;
        boolean subdiagonalIguals = true;

        for (int i = 0; i < dimensio; i++) {
            if (matriu[i][i] != matriu[0][0]) {
                diagonalMajorIguals = false;
            }

            if (matriu[i][dimensio - 1 - i] != matriu[dimensio - 1][0]) {
                subdiagonalIguals = false;
            }
        }

        if (diagonalMajorIguals) {
            System.out.println("Diagonal major amb tot iguals");
        } else {
            System.out.println("Diagonal major sense números iguals");
        }

        if (subdiagonalIguals) {
            System.out.println("Subdiagonal amb tot iguals");
        } else {
            System.out.println("Subdiagonal sense números iguals");
        }
    }
}
