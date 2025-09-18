import java.util.Random;

public class Persona {
    private String nom;
    private int edat;

    public Persona(){
        this.nom = "Aleatori";
        this.edat = new Random().nextInt(70);
    }
    public Persona(String nom, int edat) {
        this.nom = nom;
        this.edat = edat;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getEdat() {
        return edat;
    }
    public void setEdat(int edat) {
        this.edat = edat;
    }

    public String toString(){
        return "Nom: " + this.nom + " - Edat: " + this.edat;
    }
    
}
