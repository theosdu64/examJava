package org.example.Business;

import org.example.Class.*;
import org.example.Dao.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Business {
    static FormationDao formationDao = new FormationDao();
    static UtilisateurDao utilisateurDao = new UtilisateurDao();
    static ClientDao clientDao = new ClientDao();
    static CommandeDao commandeDao = new CommandeDao();
    static ArticleCommandeDao articleCommandeDao = new ArticleCommandeDao();
    private static Utilisateur userConnecte = null;
    private static Map<Formation, Integer> panier = new HashMap<>();

    public static boolean estConnecte() {
        return userConnecte != null;
    }

    public static void logout() {
        userConnecte = null;
    }

    public static Utilisateur getUserConnecte() {
        return userConnecte;
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
        } catch (Exception e) {
            System.err.println("erreur findCommandeById : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Commande createCommande(long idClient, Integer montantTotal) {
        try {
            Client client = clientDao.findById(idClient);

            if (client == null) {
                System.out.println("Client introuvable");
                return null;
            }

            Commande commande = new Commande(
                    LocalDate.now(),
                    "EN_ATTENTE",
                    montantTotal,
                    userConnecte,
                    client
            );

            commandeDao.saving(commande);

            System.out.println("commande cree");
            return commande;

        } catch (Exception e) {
            System.err.println("erreur lors de la crreation de la commande : " + e.getMessage());
            e.printStackTrace();
            return null;
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
            List<ArticleCommande> articles = findArticleCommandeById(idCommande);

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

    public static void afficherPanier() {
        if (panier.isEmpty()) {
            System.out.println("Panier vide");
            return;
        }

        System.out.println("Panier");
        double total = 0;

        for (Map.Entry<Formation, Integer> entry : panier.entrySet()) {
            Formation f = entry.getKey();
            int quantite = entry.getValue();
            double sousTotal = f.getPrix() * quantite;

            System.out.println(f.getNom() +
                    " x" + quantite +
                    " = " + sousTotal + "€");
            total += sousTotal;
        }

        System.out.println("---------------");
        System.out.println("Total : " + total + "€");
    }

    public static void ajouterAuPanier(long idFormation, int quantite) {
        Formation formation = formationDao.findById(idFormation);

        if (formation == null) {
            System.out.println("Erreur formation introuvable");
            return;
        }
        if (panier.containsKey(formation)) {
            int current = panier.get(formation);
            panier.put(formation, current + quantite);
            System.out.println("panier mis a jour: " + (current + quantite));
        } else {
            panier.put(formation, quantite);
            System.out.println("formation ajouté");
        }
    }

    public static void retirerDuPanier(long idFormation) {
        Formation formationATrouver = null;

        for (Formation f : panier.keySet()) {
            if (f.getIdFormation().equals(idFormation)) {
                formationATrouver = f;
                break;
            }
        }
    }

    public static void viderPanier() {
        panier.clear();
        System.out.println("Panier vide");
    }

    public static double calculerTotal() {
        double total = 0;
        for (Map.Entry<Formation, Integer> entry : panier.entrySet()) {
            total += entry.getKey().getPrix() * entry.getValue();
        }
        return total;
    }

    public static boolean panierEstVide() {
        return panier.isEmpty();
    }

    public static void displayAllFullCommande() {
        try {
            List<Commande> commandes = commandeDao.findAll();

            if (commandes.isEmpty()) {
                System.out.println("Aucune commande trouvée");
                return;
            }

            for (Commande commande : commandes) {
                System.out.println("\n=================================");
                System.out.println("COMMANDE N° " + commande.getIdCommande());
                System.out.println("Date : " + commande.getDateCommande());
                System.out.println("Statut : " + commande.getStatus());
                System.out.println("Client : " + commande.getClient().getNom());
                System.out.println("Utilisateur : " + commande.getUtilisateur().getEmail());
                System.out.println("\nArticles :");

                List<ArticleCommande> articles = articleCommandeDao.findByCommandId(commande.getIdCommande());

                for (ArticleCommande article : articles) {
                    System.out.println("  - " + article.getFormation().getNom());
                    System.out.println("    Quantité : " + article.getQuantite());
                    System.out.println("    Prix unitaire : " + article.getPrixUnitaire() + "€");
                    System.out.println("    Sous-total : " + article.calculerSousTotal() + "€");
                }
                System.out.println("---------------------------");
                System.out.println("Montant total : " + commande.getMontantTotal() + "€");
            }

        } catch (Exception e) {
            System.err.println("Erreur displayAllFullCommande : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public  static void getAllClient() {
        try {
            List<Client> clients = clientDao.findAll();
            for (Client c : clients) {
                System.out.println(c);
            }
        }
        catch (Exception e) {
            System.err.println("erreur getAllClient : " + e.getMessage());
        }
    }
}



