import java.util.Scanner;
public class Practica3_12 {
    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);

        System.out.println("Escriu 5 paraules: ");

        String cincParaules = "";
        
        for (int i=0; i< 5; i++){
            cincParaules = cincParaules.concat(teclat.next() + " ");
        }

        System.out.println("\n" + cincParaules);
    }
}
