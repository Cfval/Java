
public class Practica3_6_1 {
    public static void main(String[] args) {
        
        double [] arrayA = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        double [] arrayB = new double[arrayA.length];

        arrayB = arrayA;

        for(int i = 0; i < arrayA.length; i++) {
            System.out.println("Array A" + i + " " + arrayA[i]);
        }

        System.out.println();

        for(int i = 0; i < arrayB.length; i++) {
            System.out.println("Array B" + i + " " + arrayB[i]);
        }
        /**
         * o si volem nomes copiar e imprimir l'array B podem fer el seguent:
         * for (int i = 0; i < arrayA.length; i++) {
            arrayB[i] = arrayA[i];
            System.out.println(arrayB[i]);
            }
         */
    }
}
