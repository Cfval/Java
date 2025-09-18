import java.util.List;
import java.util.function.Predicate;

public class Predicats {
    public static void main(String[] args) {
        Predicats programa = new Predicats();
        programa.inici();
    }

    public void inici() {
        Predicate<Integer> p = v -> v % 5 == 0;
        System.out.println(p.test(25));
        System.out.println(p.test(24));

        Predicate<String> p2 = v -> v.length() % 2 == 0;
        System.out.println(p2.test("Hola"));
        System.out.println(p2.test("mon"));

        Predicate<String> p3 = v -> v.contains("o");
        System.out.println(p3.test("Adeu"));
        System.out.println(p3.test("Hola"));

        List<Integer> llista = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
         imprimirFiltrant(llista, v -> true);
        // imprimirFiltrant(llista, v -> v%2==0);
        // imprimirFiltrant(llista, v -> v>3 && v<6);
        // imprimirFiltrant(llista, Predicats::esPrimer);
    }

    public void imprimirFiltrant(List<Integer> llista, Predicate<Integer> predicat) {
        for (int element : llista) {
            if (predicat.test(element)) System.out.println(element);
        }
    }

    public static boolean esPrimer(int n) {
        if (n <= 1)
            return false;

        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;

        return true;
    }
}