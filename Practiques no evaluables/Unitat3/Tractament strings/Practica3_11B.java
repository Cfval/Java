import java.util.Scanner;

public class Practica3_11B {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        char caracter;

        System.out.print("Introduce un texto: \n");
        String texto = new String(input.nextLine());

        System.out.print("Introduce un caracter para buscar en el texto\n");
        caracter = input.next().charAt(0);
        if (texto.indexOf(caracter) == -1) {
            System.out.println("No encontrado");
        } else {
            System.out.print("El caracter sí está. Primera posició: " + texto.indexOf(caracter));
            System.out.print(" Ultima posició: " + texto.lastIndexOf(caracter));
        }
    }
}