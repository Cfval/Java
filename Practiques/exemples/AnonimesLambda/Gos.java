package AnonimesLambda;

public class Gos implements Comunicable {
    
    @Override
    public String comunicar(String frase) {
        return "bub bub (" + frase + ")" ;
    }
    
}
