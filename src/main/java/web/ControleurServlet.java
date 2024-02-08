package web;

import dao.IProduitdao;
import dao.ProduitdaoImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.entities.Produit;

import java.io.IOException;
import java.util.List;

public class ControleurServlet extends HttpServlet {
    public IProduitdao iProduitdao;

    @Override
    public void init() throws ServletException {
        iProduitdao = new ProduitdaoImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/index.php")) {
            request.getRequestDispatcher("Produits.jsp").forward(request, response);

        } else if (path.equals("/chercher.php")) {
            String mot = request.getParameter("motcle");
            System.out.println(mot);

            ProduitModel produitModel = new ProduitModel();

            produitModel.setMotCle(mot);

            List<Produit> produits = iProduitdao.chercher(mot);
            produitModel.setProduits(produits);
            request.setAttribute("model", produitModel);
            request.getRequestDispatcher("Produits.jsp").forward(request, response);

        }
        else if (path.equals("/Saisie.php")){
            request.setAttribute("produit",new Produit());
            request.getRequestDispatcher("SaisieProduit.jsp").forward(request, response);

        }
        else if (path.equals("/Save.php") && (request.getMethod().equals("post"))){
            System.out.println("in save");

            String des=request.getParameter("designation");
            double prix=Double.valueOf(request.getParameter("prix"));
            Long quantite=Long.parseLong(request.getParameter("quantite"));
            //System.out.println(des);
            //System.out.println();
            //System.out.println();
            Produit p=iProduitdao.save(new Produit(des,prix,quantite));
            request.setAttribute("produit",p);
            request.getRequestDispatcher("confirmation.jsp").forward(request, response);

        }
        else if(path.equals("/Supprimer.php")){
String id=request.getParameter("id");
iProduitdao.deleteProduit(Long.parseLong(id));
          //  request.getRequestDispatcher("Produits.jsp").forward(request, response);
response.sendRedirect("chercher.php?motcle=");
        }
        else if(path.equals("/Modifier.php")) {

            Long id = Long.parseLong(request.getParameter("id"));
            Produit p = iProduitdao.getProduit(id);
            request.setAttribute("ProduitEdit", p);
            request.getRequestDispatcher("EditProduit.jsp").forward(request, response);
        }
        else if(path.equals("/SaveProduit.php")){
            Long id = Long.parseLong(request.getParameter("id"));
            System.out.println("in save produit path"+ id);
            String newDes=request.getParameter("designation");
            System.out.println("in save produit path"+ newDes);

            double prix=Double.parseDouble(request.getParameter("prix"));
            System.out.println("in save produit path"+ prix);

            Long quantite=Long.parseLong(request.getParameter("quantite"));
            System.out.println("in save produit path"+ quantite);

            Produit newp=new Produit();
            newp.setId(id);
            newp.setDesignation(newDes);
            newp.setPrix(prix);
            newp.setQuantite(quantite);
            iProduitdao.updateProduit(newp);
            response.sendRedirect("chercher.php?motcle=");

        }
        else{
            response.sendError(response.SC_NOT_FOUND);
        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }
}
