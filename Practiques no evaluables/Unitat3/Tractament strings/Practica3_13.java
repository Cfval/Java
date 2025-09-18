import java.util.Scanner;

public class Practica3_13 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String[] palabras = new String[5];

        System.out.print("Introduce cinco palabras: ");

        // almacenar las 5 palabras
        for (int i = 0; i < 5; i++) {
            palabras[i] = teclado.next();
        }

        teclado.close();
        System.out.println();

        // Ordenar las 5 palabras
        for (int i = 1; i < palabras.length; i++) {
            for (int j = 0; j < palabras.length - 1; j++) {
                if (palabras[j].compareToIgnoreCase(palabras[j + 1]) > 0) {
                    String aux = palabras[j];
                    palabras[j] = palabras[j + 1];
                    palabras[j + 1] = aux;
                }
            }
        }

        // Imprimir las palabras ordenadas
        for (int i = 0; i < palabras.length; i++) {
            System.out.println(palabras[i]);
        }

        System.out.println();
    }
}
