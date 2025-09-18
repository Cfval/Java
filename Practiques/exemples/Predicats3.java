import java.util.function.Predicate;

public class Predicats3 {
    public static void main(String[] args) {
        Predicats3 programa = new Predicats3();
        programa.inici();
    }

    public void inici() {
        Persona alumne = new Persona("Jose",23);
        Predicate<Persona> majorEdat = p -> p.getEdat() >= 18;
        Predicate<Persona> nomAmbA = p -> p.getNom().contains("a");

        Predicate<Persona> majorEdatOambA = majorEdat.or(nomAmbA);
        Predicate<Persona> majorEdatIambA = majorEdat.and(nomAmbA);
        Predicate<Persona> menorEdat = majorEdat.negate();

        System.out.println(majorEdatOambA.test(alumne));
        System.out.println(majorEdatIambA.test(alumne));
        System.out.println(menorEdat.test(alumne));

    }


}

