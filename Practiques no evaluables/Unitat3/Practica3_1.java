
import java.util.Scanner;

public class Practica3_1 {
    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
        int quantitatNotes;
        // Demanem quantitat de notes i tornem a demanar si no és un enter o bé es negatiu
        System.out.print("Introdueix quantitat de notes: ");
        while (!teclat.hasNextInt() || (quantitatNotes = teclat.nextInt()) < 0 ) {
            teclat.nextLine();
            System.out.print("Introdueix quantitat de notes: ");
        }
        teclat.nextLine();

        double[] notes = new double[quantitatNotes];

        // Demanen que s'introduïsquen les notes en la mateixa línia. 
        
        System.out.println("Introdueix les notes: ");
        // El "for" repetirà la lectura "correcta" de notes, es a dir, la quantitat de notes que vol introduïr l'usuari (només les correctes)
        for (int i = 0; i < notes.length; i++) {
            // Mentre que no siga un double o bé el double siga erroni (menor que 0 o major que 10 és erroni) llegirem la següent dada del buffer.
            while(!teclat.hasNextDouble() || (notes[i] = teclat.nextDouble()) < 0 || notes[i] > 10){
                // Alliberem només una dada (next i no nextLine) si no és de tipus double. Si fora de tipus double erroni ja s'ha alliberat al fer el "nextDouble"
                if(!teclat.hasNextDouble()){
                   teclat.next(); 
                }
            }
            
        }

        for (int i = 0; i < notes.length; i++) {
            System.out.println("Nota: " + notes[i]);

        }

        teclat.close();
    }
}