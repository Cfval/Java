public class Lambda1 {
    public static void main(String[] args) {
        double n1 = 3.5;
        double n2 = 2.0;
        /*
        OperacionDouble sumar = new OperacionDouble() {

            @Override
            public double operar(double op1, double op2) {
                return op1 + op2;
            }
            
        };
        */
        OperacionDouble sumar = (a,b) -> a+b;
        System.out.println(sumar.operar(n1, n2));

        sumar = (a,b) -> a * b;
        System.out.println(sumar.operar(n1, n2));

        sumar = Lambda1::promedio;
        
        System.out.println(sumar.operar(n1, n2));


    }

    public static double promedio(double numero1, double numero2){
        return (numero1+numero2) / 2;
    }
}
