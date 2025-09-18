import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Lambda2 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // Iterador extern 1
        for(int i=0; i<numeros.size(); i++){
            System.out.println(numeros.get(i));
        }
        // Iterador extern 2
        for(int numero: numeros){
            System.out.println(numero);
        }
        // Iterador intern. Consulta el mètode "forEach"
        numeros.forEach(new Consumer<Integer>(){
            public void accept(Integer valor){
                System.out.println(valor);
            }
        });

        numeros.forEach((Integer v) -> System.out.println(v));

        numeros.forEach(v -> System.out.println(v));

        numeros.forEach(System.out::println);
        
    }
}
