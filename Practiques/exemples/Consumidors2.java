import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Consumidors2 {
    public static void main(String[] args) {
        
        List<Integer> llista = new ArrayList<>(Arrays.asList(3,1,6,5,4));
        Consumer<Integer> ci = v -> System.out.println("Valor: " + v);
        llista.forEach(ci);
        System.out.println();
        Consumer<Integer> ci2 = v -> System.out.println("Su doble es " + v*2);
        llista.forEach(ci.andThen(ci2));
        System.out.println();
        ci.andThen(ci2).andThen(v->System.out.println("Y su triple " + v*3)).accept(5);



    }
}
