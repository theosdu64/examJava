package org.example.Dao;

import org.example.Class.Client;
import org.example.Class.Commande;
import org.example.Class.Utilisateur;
import org.example.Dao.Helper.DaoHelper;
import org.example.Dao.Interface.InterfaceDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CommandeDao extends DaoHelper implements InterfaceDao<Commande> {


    @Override
    public void save(Commande entity) {
        throw new UnsupportedOperationException("non implémenté");
    }

    @Override
    public Commande findById(Long id) {
        String sql = "SELECT c.*, " +
                "u.id_utilisateur, u.email, u.password, " +
                "cl.id_client, cl.nom, cl.prenom, cl.email as email_client, cl.adresse, cl.telephone " +
                "FROM commande c " +
                "JOIN utilisateur u ON c.id_utilisateur = u.id_utilisateur " +
                "JOIN client cl ON c.id_client = cl.id_client " +
                "WHERE c.id_utilisateur = ?";
        return DaoHelper.executeQuerySingle(sql, this::mapRow, id);
    }

    @Override
    public List<Commande> findAll() {
        String sql = "SELECT c.*, " +
                "u.id_utilisateur, u.email, u.password, " +
                "cl.id_client, cl.nom, cl.prenom, cl.email as email_client, cl.adresse, cl.telephone " +
                "FROM commande c " +
                "JOIN utilisateur u ON c.id_utilisateur = u.id_utilisateur " +
                "JOIN client cl ON c.id_client = cl.id_client";
        return DaoHelper.executeQuery(sql, this::mapRow);
    }

    @Override
    public void update(Commande entity) {
        throw new UnsupportedOperationException("non implémenté");
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("non implémenté");
    }

    private Commande mapRow(ResultSet rs) throws SQLException {
        Utilisateur utilisateur = new Utilisateur(
                rs.getLong("id_utilisateur"),
                rs.getString("email")
        );
        Client client = new Client(
                rs.getLong("id_client"),
                rs.getString("nom"),
                rs.getString("prenom"),
                rs.getString("email_client"),
                rs.getString("adresse"),
                rs.getString("telephone")
        );
        return new Commande(
                rs.getLong("id_commande"),
                rs.getDate("date_commande").toLocalDate(),
                rs.getString("statut"),
                rs.getInt("montant_total"),
                utilisateur,
                client
        );
    }
}

