
public class Practica3_6 {
    public static void main(String[] args) {
        
        // COM DUPLICAR/COPIAR ARRAYS PER A QUE SIGUEN INDEPENDENTS

        double [] arrayA = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        double [] arrayB = new double[arrayA.length];
        
        // COPIA ELS VALORS UNO A UNO 
        for(int i = 0; i < arrayA.length; i++) {
            arrayB[i] = arrayA[i];
            System.out.println("Array B" + i + " " + arrayB[i]);
        } 
    }
}
