package Matrius;

/**
 * @author atataP
 */
public class Piramides2 {

    public static void main(String args[]) {
        for (char x = 'Z'; x >= 'A'; x--) {
            for (char y = x; y >= 'A'; y--) {                                                                          
                System.out.print(y);
            }
            System.out.println();
        }
    }
}
