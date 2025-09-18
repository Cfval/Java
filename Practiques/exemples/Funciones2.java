import java.util.function.*;

public class Funciones2 {
    public static void main(String[] args) {
        BiFunction<Integer,Integer,Boolean> esDivisible = (i1,i2) -> i1%i2==0;
        System.out.println(esDivisible.apply(6,2));

        IntFunction<Double> tresCuartos = v -> v*3/4.0;
        System.out.println(tresCuartos.apply(120));

        ToIntFunction<String> longitud = s -> s.length();
        System.out.println(longitud.applyAsInt("mon"));

        

        BiFunction<String,String,Function<String,String>> bf;
        bf = (a,b) -> (c) -> a+b+c;
        System.out.println(bf.apply("a","b").apply("c"));
        
        BiFunction<String,String,String> bf2;
        bf2 = (a,b) -> a+b;
        System.out.println(bf2.apply(bf2.apply("a","b"),"c"));
        
        BiFunction<Function<String,String>,String,String> bf3;
        bf3 = (a,b) -> a.apply("a")+b;
        System.out.println(bf3.apply((a) -> (a+"b"), "c"));
        
        
    }
}
