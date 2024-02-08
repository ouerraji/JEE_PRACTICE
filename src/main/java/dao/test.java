package dao;

import metier.entities.Produit;

public class test {
    public static void main(String[] args) {
        ProduitdaoImp produitdaoImp = new ProduitdaoImp();
  //      Produit p=produitdaoImp.save(new Produit("test",155,4));
//        Produit p2=produitdaoImp.save(new Produit("test2",155,4));

        //Produit p3=produitdaoImp.save(new Produit("test3",155,4));


        System.out.println(produitdaoImp.chercher("s"));
    }
}
