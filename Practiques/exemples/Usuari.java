import java.util.ArrayList;
import java.util.Collections;

public class Usuari {
    private String nom;
    private int edat;
    public Usuari(String nom, int edat){
        this.nom = nom;
        this.edat = edat;
    }
    public String getNom(){
        return nom;
    }
    public int getEdat(){
        return edat;
    }
    //...
    public static void main(String[] args) {

        ArrayList<Usuari> llista = new ArrayList<>();
        // llista.add(usuari1); llista.add(usuari2) ...
        Collections.sort(llista, 
            (o1, o2) -> o1.getEdat() - o2.getEdat()
        );

    }

}

