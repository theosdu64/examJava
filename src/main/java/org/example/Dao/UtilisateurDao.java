package org.example.Dao;

import org.example.Class.Utilisateur;
import org.example.Dao.Helper.DaoHelper;
import org.example.Dao.Interface.InterfaceDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UtilisateurDao extends DaoHelper implements InterfaceDao<Utilisateur> {

//    public void login(Utilisateur entity) {
//        String email = entity.getEmail();
//        String sql = "SELECT * FROM utilisateur WHERE email = ?";
//        Boolean validEmail = DaoHelper.executeQuerySingle(sql,this::mapRow, email);
//        if(valildEmail) {
//            String password = entity.getPassword();
//            String sql = "Select password from utilisateur WHERE email = ?";
//            Boolean validPassword = DaoHelper.executeQuerySingle(sql, this::mapRow, password);
//            if(validPassword) {
//                // je renvois un faux token c normal je sais pas trop comment gerer pour le moment
//                return "123456789"
//            }
//        }
//    }

    @Override
    public void save(Utilisateur entity) {
        String sqlCheck = "SELECT * FROM utilisateur WHERE email = ?";
        Utilisateur existe = DaoHelper.executeQuerySingle(sqlCheck, this::mapRow, entity.getEmail());

        if (existe != null) {
            throw new IllegalArgumentException("email deja utilisé : " + entity.getEmail());
        }
        String sqlInsert = "INSERT INTO utilisateur (email, password) VALUES (?, ?)";
        DaoHelper.executeInsert(sqlInsert, entity.getEmail(), entity.getPassword());
    }

    @Override
    public Utilisateur findById(Long id) {
        String sql = "SELECT * FROM utilisateur WHERE id_utilisateur=?";
        return DaoHelper.executeQuerySingle(sql, this::mapRow,id);
    }

    @Override
    public List<Utilisateur> findAll() {
        String sql = "SELECT * FROM Utilisateur";
        return DaoHelper.executeQuery(sql, this::mapRow);
    }

    @Override
    public void update(Utilisateur entity) {
        throw new UnsupportedOperationException("non implémenté");
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("non implémenté");
    }

    private Utilisateur mapRow(ResultSet rs) throws SQLException {
        return new Utilisateur(
                rs.getLong("id_utilisateur"),
                rs.getString("email"),
                rs.getString("password")
        );
    }
}
