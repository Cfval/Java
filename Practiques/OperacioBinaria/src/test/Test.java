/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import interficiesfuncionals.OperacioBinaria;

/**
 *
 * @author jrmd
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Funcions lambda
        OperacioBinaria<Integer> opInt = (op1, op2) -> op1 * op2;
        OperacioBinaria<Double> opDouble = (op1, op2) -> (op1 + op2) / 2;
        OperacioBinaria<String> opString = (op1, op2) -> op1.concat(op2);

        // Proves funcionament
        System.out.println(opInt.aplicar(3, 4));
        System.out.println(opDouble.aplicar(3.5, 7.0));
        System.out.println(opString.aplicar("Hola", " món!"));

        // Proves mètode estàtic operarDoubles.
        System.out.println(operarDoubles(3.2, 9.1, opDouble));
        System.out.println(operarDoubles(3.2, 4.0, (a, b) -> a * b));
        System.out.println(operarDoubles(0.15, 32.5, (op1, op2) -> Math.max(op1, op2)));
        System.out.println(operarDoubles(0.15, 32.5, Math::max));
        System.out.println(operarDoubles(8.36, 1.5, Test::revertirSum));

    }

    // Implementem el mètode estàtic.
    public static double operarDoubles(double op1, double op2, OperacioBinaria<Double> funcio) {
        return funcio.aplicar(op1, op2);
    }
    
    public static double revertirSum(double op1, double op2){
        double suma = op1 + op2;
        String strSuma = String.valueOf(suma);
        StringBuilder stbSuma = new StringBuilder(strSuma);
        stbSuma = stbSuma.reverse();
        return Double.parseDouble(stbSuma.toString());
    }

}
