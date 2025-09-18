package AnonimesLambda;

public class Principal {
    public static void main(String[] args) {
        Comunicable tobi = new Gos();
        System.out.println(tobi.comunicar("hola"));

         Comunicable lassie = new Comunicable(); 

        /* Comunicable lassie = new Comunicable() {
            @Override
            public String comunicar(String frase) {
                return "bub bub (" + frase + ")";
            } 
        };
        System.out.println(lassie.comunicar("bona nit")); */

        /* Comunicable asturiana = (String s) -> {
            return "muuuu (" + s + ")";
        };
        System.out.println(asturiana.comunicar("bon profit")); */

        /* Comunicable felix = s -> "miauu ("+s+")";
        System.out.println(felix.comunicar("tinc fred")); */



    }
}
