import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.function.Function;
import java.util.function.Supplier;

public class ReferenciaMetodes2 {
    public static void main(String[] args) {
        Function<Usuari,String> funcioNom = Usuari::getNom;
        Usuari u1 = new Usuari("Antonio", 33);
        System.out.println(funcioNom.apply(u1));

        LinkedList<Integer> llista = new LinkedList<>(Arrays.asList(2,6,9,3));
        Supplier<Integer> eliminarUltim = llista::removeLast;

        System.out.println(eliminarUltim.get());
        System.out.println(llista.toString());

        Supplier<Persona> generarPersona = Persona::new;
        Persona p1 = generarPersona.get();
        Persona p2 = generarPersona.get();

        Function<Integer,ArrayList<Persona>> generarPersones = n -> {
            ArrayList<Persona> persones = new ArrayList<>();
            for(int i=0; i<n; i++){
                persones.add(generarPersona.get());
            }
            return persones;
        };

        ArrayList<Persona> equip = generarPersones.apply(8);
        System.out.println(equip.toString());


    }
}
