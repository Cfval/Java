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
public class ProjecteZero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int suma = Operacions.sumar(3,6);
        int resta = Operacions.restar(6,1);
        int multiplicacio = Operacions.multiplicar(5,4);
        double divisio = Operacions.dividir(5,2);
        double potencia = Operacions.potencia(2, 5);
        if(Operacions.esParell(multiplicacio)){
            System.out.println(Operacions.arrel(multiplicacio));
        }
    }
    
}
