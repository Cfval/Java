import java.util.function.Predicate;

public class Predicats2 {
    public static void main(String[] args) {
        Predicats2 programa = new Predicats2();
        programa.inici();
    }

    public void inici() {
        Predicate<Integer> p1 = divisible(2);
        System.out.println(p1.test(12));
        System.out.println(p1.test(31));

        Predicate<Integer> p2 = divisible(5);
        System.out.println(p2.test(12));
        System.out.println(p1.test(15));
        // imprimirFiltrant(llista, divisible(3));

    }

    Predicate<Integer> divisible(int valor){
        return n -> n%valor == 0;
    }
}

