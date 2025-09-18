import java.util.Scanner;

public class Practica3_11 {
    public static void main(String[] args) {

        Scanner teclat = new Scanner(System.in);

        System.out.println("Introduce una frase");
        String texto = teclat.nextLine();

        for (int i = 0; i < texto.length(); i++) {
            System.out.print((char) (texto.charAt(i) - 32));

        }

    }
}