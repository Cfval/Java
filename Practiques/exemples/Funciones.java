import java.util.function.Function;

public class Funciones {
    public static void main(String[] args) {
        
        Function<Integer,Double> f1 = i -> i/2.0;
        System.out.println(f1.apply(35));
        System.out.println(f1.apply(32));

        Function<Integer,String> f2 = i-> String.valueOf(i);
        System.out.println(f2.apply(35));
        Function<String,String> f3 = s -> "'" + s + "'";
        System.out.println(f3.apply("Hola"));
        Function<Integer,String> f4 = f3.compose(f2);
        System.out.println(f4.apply(35));

        System.out.println(f2.andThen(f3).apply(38));

        
    }
}
