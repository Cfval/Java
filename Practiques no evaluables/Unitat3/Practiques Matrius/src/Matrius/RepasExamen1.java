package Matrius;
/**
 *
 * @author atataP
 */
public class RepasExamen1 {
    public static void main(String args[]) {
        
        double suma = 0;
        double mitjana;
        double [] array = {2.2, 6.6, 4.5, 9.3, 1.2};
        
        for(int i = 0;i < array.length;i++){
            
            suma += array[i]; 
            
        }
        mitjana = suma/array.length;
        System.out.println(array.length);
        System.out.println(array.length - 1);
        System.out.printf("%.2f\n", mitjana);
    }
}
