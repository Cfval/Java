
public class Practica3_9 {
    public static void main(String[] args) {
        float suma = 0;
        float millorNotaMitjana = 0;
        float notaMaxima = 0;  //nota máxima de cada alumne
        float notaAlta = 0; //
        float majorNotaIndividual = 0;
        int mitjaAlumne = 0;
        int maximaAlumne = 0;

        // creació de arrays
        String [] noms = { "Espinete", "Don Pinpon", "Gustavo", "Triki" };
        float [][] notes = {
            { 6.0f, 7.2f, 2.3f, 5.8f, 3.4f },
            { 7.8f, 1.6f, 4.6f, 9.4f, 3.1f },
            { 3.6f, 1.4f, 8.9f, 3.5f, 6.5f },
            { 2.5f, 3.0f, 10.0f, 2.4f, 8.9f }
        };
        float [][] dadesAlumnes = new float [4][2]; // crea l'array pa guardar la nota máxima de cada alumne i la mitja.
        
        for(int i = 0; i < notes.length; i++){
            for(int j = 0; j < notes[i].length; j ++){

                suma += notes[i][j];

                if (notes[i][j] > notaMaxima){
                    notaMaxima = notes [i][j];
                }
                
                if (notes [i][j] > majorNotaIndividual){
                    majorNotaIndividual = notes[i][j];
                }
                dadesAlumnes [i][0] = suma / notes[i].length; // guardem la nota mitja del alumne
                dadesAlumnes [i][1] = notaMaxima;             // guardem la nota máxima del alumne
            }
           
            suma= 0;
            notaMaxima = 0;
        }

        for(int i = 0; i < dadesAlumnes.length; i++){

            if(dadesAlumnes[i][0] > millorNotaMitjana) {
                millorNotaMitjana = dadesAlumnes[i][0];
                mitjaAlumne = i;               // agafem la posició de l'alumne amb la mitja més alta
            }
            
            if(dadesAlumnes[i][1] > dadesAlumnes.length){ 
                notaAlta = dadesAlumnes[i][1];
                maximaAlumne = i;             // agafem la posició de l'alumne amb la nota més alta
            }
        }

        System.out.printf("Alumne amb millor nota mitja " + noms[mitjaAlumne] + ", la seua nota es de  %.1f", millorNotaMitjana);
        System.out.printf("\nLa nota mes alta es de " + noms[maximaAlumne] + " amb una nota de %.1f", notaAlta);
        System.out.println("\nMillor nota individual: "+ majorNotaIndividual);
    }
}
