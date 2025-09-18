package model;

public class Oficina {
    private int oficinaId;
    private String ciutat;
    private int superficie;
    private double vendes;
    
    public Oficina(int oficinaId, String ciutat, int superficie, double vendes) {
        this.oficinaId = oficinaId;
        this.ciutat = ciutat;
        this.superficie = superficie;
        this.vendes = vendes;
    }
    
     public int getOficinaId() {
        return oficinaId;
    }

    public String getCiutat() {
        return ciutat;
    }

    public int getSuperficie() {
        return superficie;
    }

    public double getVendes() {
        return vendes;
    }

    // Setters
    public void setOficinaId(int oficinaId) {
        this.oficinaId = oficinaId;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public void setVendes(double vendes) {
        this.vendes = vendes;
    }
    
    @Override
    public String toString() {
        return "Oficina{" +
               "oficinaId=" + oficinaId +
               ", ciutat='" + ciutat + '\'' +
               ", superficie=" + superficie +
               ", vendes=" + vendes +
               '}';
    }    
}
