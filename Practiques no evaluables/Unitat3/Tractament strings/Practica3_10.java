/**
 * Cfval
 * El funcionament es donar una frase y que la torne a l'inversa
 */
import java.util.Scanner;
public class Practica3_10 {
    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);

        System.out.println("Escriu una frase: ");
        String text = teclat.nextLine(); //Next si nomes volem una "paraula"

        System.out.println("Ací tens la frase a l'inversa: ");
        for(int i = text.length() - 1; i >= 0; i--){
            System.out.print(text.charAt(i)); 
        }
    }
}