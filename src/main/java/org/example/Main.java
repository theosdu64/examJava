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
        }
    }
}
