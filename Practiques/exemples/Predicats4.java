import java.util.function.BiPredicate;

public class Predicats4 {
    public static void main(String[] args) {
        BiPredicate<Integer,Integer> bp = (n1,n2) -> n1 % n2 == 0;
        System.out.println(bp.test(8, 2));
        bp = (n1,n2) -> n1 < n2;
        System.out.println(bp.test(8, 2));

        
    }
}
