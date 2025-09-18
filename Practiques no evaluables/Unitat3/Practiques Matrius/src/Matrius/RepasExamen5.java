package Matrius;

/**
 * @author atataP
 */
public class RepasExamen5 {
    public static void main(String[] args) {
        double[][] matriu1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        double[][] matriu2 = {
                {10, 20, 30},
                {40, 50, 60},
                {70, 80, 90}
        };
      
        for (int i = 0;i < matriu2.length; i++){
            for(int j = 0; j < matriu2[i].length; j++){
                matriu1[i][j] = matriu1[i][j] + matriu2[(matriu2.length -1)- i][(matriu2[j].length - 1) - j];
                System.out.print(matriu1 [i][j] + " ");
            }
            System.out.println();
        }
    }
}
