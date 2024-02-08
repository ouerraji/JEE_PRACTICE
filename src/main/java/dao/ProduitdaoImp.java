package dao;

import metier.entities.Produit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduitdaoImp implements IProduitdao {
    @Override
    public Produit save(Produit p) {
        Connection connection = SingletonConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PRODUITS(DESIGNATION,PRIX,QUANTITE) VALUES (?,?,?)");
            preparedStatement.setString(1, p.getDesignation());
            preparedStatement.setDouble(2, p.getPrix());
            preparedStatement.setLong(3, p.getQuantite());
            preparedStatement.executeUpdate();
            PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT MAX(ID) AS MAX_ID FROM PRODUITS");
            ResultSet rs = preparedStatement2.executeQuery();
            if (rs.next()) {
                p.setId(rs.getLong("MAX_ID"));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }
    @Override
    public List<Produit> chercher(String mc) {
        Connection connection = SingletonConnection.getConnection();

        List<Produit> produits = new ArrayList<Produit>();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PRODUITS WHERE DESIGNATION LIKE ?");
            preparedStatement.setString(1, "%" + mc + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Produit p = new Produit();
                p.setId(rs.getInt("ID"));
                p.setPrix(rs.getDouble("PRIX"));
                p.setQuantite(rs.getLong("QUANTITE"));
                p.setDesignation(rs.getString("DESIGNATION"));
                produits.add(p);

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return produits;
    }

    @Override
    public Produit getProduit(long id) {
        Connection connection = SingletonConnection.getConnection();
        Produit p = new Produit();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM PRODUITS WHERE ID=?");
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                p.setDesignation(rs.getString("DESIGNATION"));
                p.setId(rs.getLong("ID"));
                p.setPrix(rs.getDouble("PRIX"));
                p.setQuantite(rs.getLong("QUANTITE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public Produit updateProduit(Produit p) {
        Connection connection = SingletonConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE PRODUITS SET DESIGNATION = ? , PRIX=? , QUANTITE=? WHERE ID=?");
            preparedStatement.setString(1, p.getDesignation());
            preparedStatement.setDouble(2, p.getPrix());
            preparedStatement.setLong(3, p.getQuantite());
            preparedStatement.setLong(4, p.getId());
            preparedStatement.executeUpdate();
            p.setId(p.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public void deleteProduit(long id) {
        Connection connection = SingletonConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM PRODUITS WHERE ID=?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
