package org.example;
import org.example.Business.Business;
import org.example.Class.Utilisateur;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Main.class.getName());
//        Utilisateur mathieu = new Utilisateur(
//                "test01@gmail.com",
//                "etoile64"
//        );
        //  Tester la connexion
        Business.test_connection();
        // Récupérer tte les formations
//        logger.info("----------------------------------------");
//        Business.getAllFormation();
//        // Formation Par Id
//        logger.info("----------------------------------------");
//        Business.getFormationById(1);
//        logger.info("----------------------------------------");
//        Business.getFormationByType("présentiel");
          logger.info("----------------------------------------");
          System.out.println(Business.login("test@gmail.com", "etoile64"));
          logger.info("----------------------------------------");
          System.out.println(Business.estConnecte());
//        Business.saveUtilisateur(mathieu);
//        Business.searchByKeyWord("java");
//            Business.getClient(1);

        logger.info("----------------------------------------");
        Business.createCommande(1L, 1500);
    }
}
