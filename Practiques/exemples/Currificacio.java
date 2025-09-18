import java.util.function.Function;

public class Currificacio {
    public static void main(String[] args) {
        var esDivisiblePer3 = esDivisible(3);
        var esDivisiblePer5 = esDivisible(5);

        System.out.println(esDivisiblePer3.apply(10));
        System.out.println(esDivisiblePer5.apply(10));
    }

    // Funció sense currificar
    public static Boolean esDivisible(Integer dividend, Integer divisor){
        return dividend % divisor == 0;
    }

    // Funció currificada
    public static Function<Integer,Boolean> esDivisible(Integer divisor){
        return dividend -> dividend%divisor==0;
    }

    
}
