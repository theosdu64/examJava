package org.example.Business;

import org.example.Class.Formation;
import org.example.ConnexionBDD;
import org.example.Dao.FormationDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Business {
    static FormationDao formationDao = new FormationDao();

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
}
