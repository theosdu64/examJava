package org.example;

import org.example.Business.Business;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenue");
        boolean shop = true;

        while (shop) {
            System.out.println("Menu Principal");
            System.out.println("1. Voir les formation");
            System.out.println("2. Chercher les formation par mot cle");
            System.out.println("3. Filtrer le formation par type(dist/pres)");
            System.out.println("4. Gerer mon panier");
            System.out.println("5. Voir mes commandes");
            System.out.println("6. Passer mes commande");
            System.out.println("7. Se connecter");
            System.out.println("8. Créer un compte");
            System.out.println("9. Se deconnecter");
            System.out.println("0. Quitter");

            int choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    Business.getAllFormation();
                    break;
                case 2:
                    System.out.print("Mot-clé : ");
                    String keyword = scanner.nextLine();
                    Business.searchByKeyWord(keyword);
                    break;
                case 3:
                    try {
                        System.out.print("Type (presentiel/distanciel) (1 ou 2) : ");
                        String type = scanner.nextLine();

                        if (type.equals("1")) {
                            Business.getFormationByType("présentiel");
                        } else if (type.equals("2")) {
                            Business.getFormationByType("distanciel");
                        } else {
                            throw new IllegalArgumentException("Choix invalide");
                        }
                    } catch (Exception e) {
                        System.out.println("Erreur : " + e.getMessage());
                    }
                    break;
                case 4:
                    menuPanier(scanner);
                    break;
            }
        }
    }
    public static void menuPanier(Scanner scanner) {
        boolean retour = false;

        while (!retour) {
            System.out.println("\nPanier");
            System.out.println("1. Voir mon panier");
            System.out.println("2. Ajouter une formation");
            System.out.println("3. Retirer une formation");
            System.out.println("4. Vider le panier");
            System.out.println("5. Retour");
            System.out.print("Votre choix : ");

            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    Business.afficherPanier();
                    break;
                case 2:
                    Business.getAllFormation();
                    System.out.println("-----------------");
                    long idFormation = scanner.nextLong();
                    int  quantite = scanner.nextInt();
                    scanner.nextLine();
                    Business.ajouterAuPanier(idFormation, quantite);
                    break;
                case 3:
                    Business.afficherPanier();
                    System.out.print("saisir id de la formation a retire du panier : ");
                    long idRetirer = scanner.nextLong();
                    scanner.nextLine();
                    Business.retirerDuPanier(idRetirer);
                    break;
                case 4:
                    Business.viderPanier();
                    break;
                case 5:
                    retour = true;
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        }
    }
}
