/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectezero;

/**
 *
 * @author jmas
 */
public class Operacions {
    public static int sumar(int a, int b){
        return a + b;
    }
    public static int restar(int a, int b){
        return a - b;
    }
    public static int multiplicar(int a, int b){
        return a * b;
    }
    public static double dividir(int a, int b){
        return (double) a / b;
    }
    public static double arrel(int a){
        return Math.sqrt(a);
    }
    public static double potencia(int b, int e){
        return Math.pow(b, e);
    }
    public static boolean esParell(int n){
        return n % 2 == 0;
    }
    
}
