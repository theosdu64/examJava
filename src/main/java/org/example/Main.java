package org.example;
import org.example.Business.Business;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Main.class.getName());
        //  Tester la connexion
        Business.test_connection();
        // Récupérer tte les formations
        logger.info("----------------------------------------");
        Business.getAllFormation();
        // Formation Par Id
        logger.info("----------------------------------------");
        Business.getFormationById(1);
        logger.info("----------------------------------------");
        Business.getFormationByType("présentiel");
    }
}
