package org.example.Dao;

import org.example.Class.ArticleCommande;
import org.example.Class.Commande;
import org.example.Class.Formation;
import org.example.Dao.Helper.DaoHelper;
import org.example.Dao.Interface.InterfaceDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ArticleCommandeDao extends DaoHelper implements InterfaceDao<ArticleCommande> {

    public List<ArticleCommande> findByCommandId(long id) {
        String sql = "SELECT ac.*, " +
                "f.id_formation, f.nom, f.description, f.duree_jours, f.type_formation, f.prix " +
                "FROM article_commande ac " +
                "JOIN formation f ON ac.id_formation = f.id_formation " +
                "WHERE ac.id_commande = ?";
        return DaoHelper.executeQuery(sql, this::mapRow, id);
    }

    public void save(ArticleCommande entity) {
        String sql = "INSERT INTO article_commande (quantite, prix_unitaire, id_commande, id_formation) " +
                "VALUES (?, ?, ?, ?)";

        long newId = DaoHelper.executeInsert(
                sql,
                entity.getQuantite(),
                entity.getPrixUnitaire(),
                entity.getCommande().getIdCommande(),
                entity.getFormation().getIdFormation()
        );

        entity.setIdArticleCommande(newId);
        System.out.println("save article commande : " + newId);
    }

    @Override
    public ArticleCommande findById(Long id) {
        throw new UnsupportedOperationException("non implémenté");
    }

    @Override
    public List<ArticleCommande> findAll() {
        throw new UnsupportedOperationException("non implémenté");
    }

    @Override
    public void update(ArticleCommande entity) {
        throw new UnsupportedOperationException("non implémenté");
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("non implémenté");
    }

    private ArticleCommande mapRow(ResultSet rs) throws SQLException {
        Commande commande = new Commande(
                rs.getLong("id_commande"),
                null,
                null,
                null,
                null,
                null
        );
        Formation formation = new Formation(
                rs.getLong("id_formation"),
                rs.getString("nom"),
                rs.getString("description"),
                rs.getInt("duree_jours"),
                rs.getString("type_formation"),
                rs.getDouble("prix")
        );
        return new ArticleCommande(
                rs.getLong("id_article_commande"),
                rs.getInt("quantite"),
                rs.getDouble("prix_unitaire"),
                commande,
                formation
        );
    }
}
