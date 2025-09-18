import java.util.Random;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class Proveidors {
    public static void main(String[] args) {
        IntSupplier s = () -> new Random().nextInt(10);
        int n1 = s.getAsInt();
        int n2 = s.getAsInt();
        System.out.println(n1 + " " + n2);

        Supplier<Persona> sp = () -> new Persona(); // Persona::new
        Persona p1 = sp.get();
        Persona p2 = sp.get();
        System.out.println(p1);
        System.out.println(p2);

    }
}
