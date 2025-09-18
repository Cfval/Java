import java.util.Arrays;
import java.util.function.Function;

public class ReferenciaMetodes {
    public static void main(String[] args) {
        Double[] valors = {3.5,5.2,2.0,10.7};
        aplicar(valors, x -> x * 2);
        System.out.println(Arrays.toString(valors));

        aplicar(valors, Math::sqrt);
        System.out.println(Arrays.toString(valors));
    }

    public static void aplicar(Double[] llista, Function<Double, Double> funcio) {
        for (int i = 0; i < llista.length; i++) {
            llista[i] = funcio.apply(llista[i]);
        }
    }
}
