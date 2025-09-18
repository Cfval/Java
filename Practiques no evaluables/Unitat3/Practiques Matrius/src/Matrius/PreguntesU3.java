package Matrius;
/**
 *
 * @author atataP
 */
public class PreguntesU3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        
        //PREGUNTA 2
        /**
        int[][] array = new int [5][6];
        int[] x = {1, 2};
        
        array[0] = x; //guarda els elements de x en la fila 0
        
        System.out.println("array [0][1] es " + array[0][1]);  // 2
        System.out.println("array [0][0] es " + array[0][0]);  // 1
        
        System.out.println("array [0][3] es " + array[0][3]);  //donaria error perque no tenim eixa llargaria
        */
        
        //PREGUNTA 3
        
        //int [][] r = new int [2]; - no es valid
        //int [][] r = new int [2][]; - es valid, podem asignar columnes després
        //r[1] = new int [5]; - asignem una columna a la fila 1 
        
        //int[] x = new int[]; - no es valid
        
        //int[][] y = new int [3][]; - si es valid
        
        //int[][] z = {{1,2}}; - si es valid
        //System.out.println(z[0][1]);
        
        /*
        int[][] n = {{1,2}, {3,4}, }; - si es valid
        System.out.println(n[1][1]);
        System.out.println(n[0][0]);
        */
        
        /*PREGUNTA 5  - recorre l'array cap arrere
        int [][] array = {{1, 2}, {3, 4}, {5, 6}};
        for(int i = array.length-1;i >= 0;i--){
            for(int j = array[i].length-1;j >= 0;j--){
                System.out.print(array [i][j] + " ");
                System.out.println();
            }
        }*/
        
        /*PREGUNTA 6 - suma el primer element de cada fila
        int [][] array = {{1, 2}, {3, 4}, {5, 6}};
        int suma = 0; 
        for(int i = 0; i<array.length;i++){
            suma += array [i][0];
            
            System.out.println(suma);
        }*/
        
    }
}
