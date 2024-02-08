package dao;

import metier.entities.Produit;

import java.util.List;

public interface IProduitdao {
    public Produit save (Produit p);
    public List<Produit> chercher(String mc);
    public Produit getProduit(long id);
    public Produit updateProduit(Produit p);
    public  void deleteProduit(long id);
}
