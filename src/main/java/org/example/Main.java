package org.example;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = ConnexionBDD.getConnection();
            System.out.println("✅ Connexion réussie à la BDD !");
            conn.close();
        } catch (SQLException e) {
            System.err.println("❌ Erreur de connexion : " + e.getMessage());
        }
    }
}
