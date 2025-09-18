
import java.util.Scanner;

public class Practica3_2_3_4 {
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
                if (notes[i] == -1){
                    break;
                } else {
                    if(!teclat.hasNextDouble()){
                        teclat.next(); 
                    }
                }
            }

            if (notes[i] == -1){
                notes[i] = 0;
                break;
            }
        }
        // imprimim totes les notes
        for (int i = 0; i < notes.length; i++) {
            System.out.println("Nota: " + notes[i]);

        }
        // fem la suma de totes les notes per a poder traure la mitjana.
        double sumaNotes, mitjanaAritmetica;
        sumaNotes = 0;

        for (int i = 0; i < notes.length; i++) {
            sumaNotes = sumaNotes + notes[i];
        }
        
        mitjanaAritmetica = sumaNotes/notes.length;

        // per a traure la nota máxima
        double notaMaxima;
        notaMaxima = 0;
        for (int i = 0; i < notes.length; i++) {
            
            if(notaMaxima < notes[i]){
                notaMaxima = notes[i];
            } 
        }
        // imprimim la mitjana y la nota màxima
        System.out.printf("La teua mitja es: %.2f i la nota máxima es: %.2f\n", mitjanaAritmetica, notaMaxima);
        
        // buscar una nota dins de l'array
        // Hi ha que netejar el buffer si anem a tornar a utilizar el teclat
        teclat.nextLine();

        double busquedaNota, a;
        a = -1;
        System.out.println("Quina nota vols buscar? ");

        if (teclat.hasNextDouble()){
            
            busquedaNota = teclat.nextDouble();

            if (!(busquedaNota < 0 || busquedaNota > 10)){
                for (int i = 0; i < notes.length; i++) {
                    a = notes[i];
                    if(busquedaNota == notes[i]){
                        System.out.println("La posició de la nota en l'array es la nº "+ (i+1));
                        break;
                    }  
                }
                if (busquedaNota != a){
                    System.out.println("La nota X no existeix");
                }         
            } else {
                System.out.println("La nota X no existeix");
            }
        } else {
            System.out.println("La nota X no existeix");
        }

        teclat.close();
    }
}




