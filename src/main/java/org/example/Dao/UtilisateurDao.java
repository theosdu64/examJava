package org.example.Dao;

import org.example.Class.Utilisateur;
import org.example.Dao.Helper.DaoHelper;
import org.example.Dao.Interface.InterfaceDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UtilisateurDao extends DaoHelper implements InterfaceDao<Utilisateur> {
    public Utilisateur login(String email, String password) {
        String sql = "SELECT * FROM utilisateur WHERE email = ?";
        Utilisateur user  = DaoHelper.executeQuerySingle(sql,this::mapRow, email);
        if(user == null) {
          return null;
        }
        if(user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }

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
