package Matrius;

public class RepasExamen7 {
    public static void main(String[] args) {
        double[][][] notes  = {
            {{7.5, 20.5}, {9.0, 22.5}, {15, 33.5}, {13, 21.5}, {15, 2.5}},
            {{4.5, 21.5}, {9.0, 22.5}, {15, 34.5}, {12, 20.5}, {14, 9.5}},
            {{6.5, 30,5}, {9.4, 10.5}, {11, 33.5}, {11, 23.5}, {10, 2.5}},
            {{6.5, 23.5}, {9.4, 32.5}, {13, 34.5}, {11, 20.5}, {16, 7.5}},
            {{8.5, 26.5}, {9.4, 52.5}, {13, 36.5}, {13, 24.5}, {16, 2.5}},
            {{9.5, 20.5}, {9.4, 42.5}, {13, 31.5}, {12, 20.5}, {16, 6.5}}
        };

        // A) PROGRAMA QUE CALCULA LA NOTA TOTAL OBTINGUDA PEL SEGON ALUMNE EN EL TERCER EXAMEN
        // RECORDEM QUE LA TEORICA ÉS SOBRE 20 I LA PRÀCTICA SOBRE 60 
        double notaTeorica = notes[1][2][0];
        // LA MATEIXA NOTA ARA SOBRE 10 PUNTS
        notaTeorica /= 2;
        double notaPractica = notes[1][2][1];
        // LA MATEIXA NOTA ARA SOBRE 10 PUNTS
        notaPractica /= 6;
        double notaApartatA = (notaTeorica + notaPractica) / 2; 
        System.out.printf("La nota del segón alumne en el tercer examen és un %.2f\n", notaApartatA);
        System.out.println();

        //B) PUNTUACIÓ MITJANA DE LES PRÀCTIQUES DE L'ÚLTIM ALUMNE
        int posicioUltimAlumne = notes.length - 1;
        double mitjana = 0;
        for (int i = 0; i < notes[posicioUltimAlumne].length; i++) {
            mitjana += notes[posicioUltimAlumne][i][1];
        }
        mitjana /= notes[posicioUltimAlumne].length;
        System.out.printf("La nota mitjana de pràctiques de l'últim alumne és de %.2f, que sobre deu és un %.2f\n", mitjana, mitjana/6);
        System.out.println();
        
        //C) QUANTITAT D'ALUMNES QUE HAN APROVAT LA PART TEÒRICA EN CADA EXAMEN
        int quantitatAprovats;
        for (int i = 0; i < notes.length; i++) {
            quantitatAprovats = 0;
            for (int j = 0; j < notes[i].length; j++) {
                if(notes[i][j][0] >= 10){
                    quantitatAprovats++;
                }
            }
            System.out.println("En l'examen " + (i+1) + " han aprovat " + quantitatAprovats + " persones la part teòrica.");
        }
    }
}
