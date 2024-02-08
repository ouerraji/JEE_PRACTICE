package metier.entities;

import java.io.Serializable;

public class Produit implements Serializable {
    private long id;
    private String designation;
    private double prix;
    private long quantite;

    public long getId() {
        return id;
    }

    public String getDesignation() {
        return designation;
    }

    public double getPrix() {
        return prix;
    }

    public long getQuantite() {
        return quantite;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setQuantite(long quantite) {
        this.quantite = quantite;
    }

    public Produit() {
    }

    public Produit(String designation, double prix, long quantite) {
        this.designation = designation;
        this.prix = prix;
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                ", prix=" + prix +
                ", quantite=" + quantite +
                '}';
    }
}
