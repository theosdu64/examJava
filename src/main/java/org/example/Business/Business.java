package org.example.Business;

import org.example.Class.*;
import org.example.ConnexionBDD;
import org.example.Dao.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Business {
    static FormationDao formationDao = new FormationDao();
    static UtilisateurDao utilisateurDao = new UtilisateurDao();
    static ClientDao clientDao = new ClientDao();
    static CommandeDao commandeDao = new CommandeDao();
    static ArticleCommandeDao articleCommandeDao = new ArticleCommandeDao();
    private static Utilisateur userConnecte = null;

    public static boolean estConnecte() {
        return userConnecte != null;
    }

    public static Utilisateur getUserConnecte() {
        return userConnecte;
    }

    public static void test_connection() {
        try {
            Connection conn = ConnexionBDD.getConnection();
            System.out.println("Connecté");
            conn.close();
        } catch (SQLException e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }

    public static void getAllFormation() {
        try {
            List<Formation> formations = formationDao.findAll();

            for (Formation f : formations) {
                System.out.println(f);
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de la recuperation formation");
            e.printStackTrace();
        }
    }

    public static void getFormationById(long id) {
        try {
            Formation formation = formationDao.findById(id);
            System.out.println(formation);
        } catch (Exception e) {
            System.err.println("Erreur lors de la recuperation d'une formation");
            e.printStackTrace();
        }
    }

    public static void getFormationByType(String type) {
        try {
            List<Formation> formations = formationDao.findbyType(type);
            for (Formation f : formations) {
                System.out.println(f);
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de la recuperation des formation du type : " + type);
            e.printStackTrace();
        }
    }

    public static void searchByKeyWord(String keyWord) {
        try {
            List<Formation> formations = formationDao.searchByKeyWord(keyWord);
            for (Formation f : formations) {
                System.out.println(f);
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de la recherche de formation : " + keyWord);
            e.printStackTrace();
        }
    }

    public static void saveUtilisateur(Utilisateur utilisateur) {
        try {
            utilisateurDao.save(utilisateur);
            System.out.println("Utilisateur crée : " + utilisateur.getEmail());
        } catch (Exception e) {
            System.err.println("Erreur lors de lajout du nouvelle utilisateur : " + utilisateur);
            e.printStackTrace();
        }
    }

    public static Utilisateur login(String email, String password) {
        try {
            Utilisateur user = utilisateurDao.login(email, password);

            if (user != null) {
                System.out.println("connexion reussi : " + user.getEmail());
                userConnecte = user;
            } else {
                System.out.println("email ou mdp incorrect");
            }
        } catch (Exception e) {
            System.err.println("erreur login : " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public static void getClient(long id) {
        try {
            Client client = clientDao.findById(id);
            System.out.println(client);
        } catch (Exception e) {
            System.err.println("erreur getClient : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void findAllCommande() {
        try {
            List<Commande> commandes = commandeDao.findAll();
            for (Commande c : commandes) {
                System.out.println(c);
            }
        } catch (Exception e) {
            System.err.println("erreur findallClient : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void findCommandeById(long id) {
        try {
            Commande commande = commandeDao.findById(id);
            System.out.println(commande);
        }  catch (Exception e) {
            System.err.println("erreur findCommandeById : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void createCommande(Long idClient, Integer montantTotal) {
        try {
            Client client = clientDao.findById(idClient);
            Commande commande = new Commande(
                    LocalDate.now(),
                    "EN_ATTENTE",
                    montantTotal,
                    userConnecte,
                    client
            );
            commandeDao.save(commande);
            System.out.println("commande cree");
        } catch (Exception e) {
            System.err.println("erreur lors de la commande");
            e.printStackTrace();
        }
    }

    public static List<ArticleCommande> findArticleCommandeById(long id) {
        try {
            return articleCommandeDao.findByCommandId(id);
        } catch (Exception e) {
            System.err.println("Erreur articleCommandeById : " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void displayFullCommande(long idCommande) {
        try {
            Commande commande = commandeDao.findById(idCommande);
            List<ArticleCommande> articles = findArticleCommandeById(idCommande);  // 👈 List<ArticleCommande>

            System.out.println("COMMANDE N° " + commande.getIdCommande());
            System.out.println("Date : " + commande.getDateCommande());
            System.out.println("Status : " + commande.getStatus());
            System.out.println("Client : " + commande.getClient().getNom());
            System.out.println("User : " + commande.getUtilisateur().getEmail());
            System.out.println("Articles :");
            System.out.println();

            for (ArticleCommande article : articles) {
                System.out.println("  - " + article.getFormation().getNom() + "\n - Quantite :" +
                         article.getQuantite() +
                         "\n - Prix :" +
                         article.calculerSousTotal() + "€");
            }
            System.out.println();
            System.out.println("Montant total : " + commande.getMontantTotal() + "€");

        } catch (Exception e) {
            System.err.println("Erreur displayFullCommande : " + e.getMessage());
            e.printStackTrace();
        }
    }
}



