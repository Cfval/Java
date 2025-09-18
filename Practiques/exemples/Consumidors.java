import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class Consumidors {
    public static void main(String[] args) {
        Consumer<Integer> ci = v -> System.out.println("Valor: " + v);
        ci.accept(3);
        ci.accept(-5);
        Consumer<String> cs = s -> System.out.println(new StringBuilder(s).reverse().toString());
        cs.accept("Hola");
        cs.accept("Mon");
        Consumer<List<Integer>> cli = l -> Collections.sort(l);
        List<Integer> llista = new ArrayList<>(Arrays.asList(3,1,6,5,4));
        cli.accept(llista);
        System.out.println(llista.toString());

    }
}
