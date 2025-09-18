public class ConceptesBasics{
    public static void main(String[] args){
        imprimirMenu();
        // Altres instruccions
        imprimirMenu();
    }


    public static void imprimirMenu(){
        System.out.println("--MENÚ DEL PROGRAMA--");
        System.out.println("---------------------");
        imprimirOpcio(1, "Sumar");
        imprimirOpcio(2, "Restar");
        imprimirOpcio(3, "Multiplicar");
        imprimirOpcio(4, "Dividir");
        System.out.println();
    }

    public static void imprimirOpcio(int numero, String opcio){
        System.out.println(numero + ". " + opcio);
    }
}