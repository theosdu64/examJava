package org.example.Dao;

import org.example.Class.Formation;
import org.example.Dao.Helper.DaoHelper;
import org.example.Dao.Interface.InterfaceDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FormationDao extends DaoHelper implements InterfaceDao<Formation> {
    @Override
    public void save(Formation entity) {
        throw new UnsupportedOperationException("non implémenté");
    }

    @Override
    public Formation findById(Long id) {
        String sql = "SELECT * FROM formation WHERE id_formation=?";
        return DaoHelper.executeQuerySingle(sql, this::mapRow,id);
    }

    @Override
    public List<Formation> findAll() {
        String sql = "SELECT * FROM formation";
        return DaoHelper.executeQuery(sql, this::mapRow);
    }

    public List<Formation> searchByKeyWord(String keyword) {
        String sql = " SELECT * FROM formation WHERE LOWER(nom) LIKE LOWER(?) OR LOWER(description) LIKE LOWER(?);";
        String pattern = "%" + keyword + "%";
        return DaoHelper.executeQuery(sql, this::mapRow,pattern,pattern);
    }

    public List<Formation> findbyType(String type) {
        String sql = "SELECT * FROM formation  WHERE type_formation=?";
        return DaoHelper.executeQuery(sql, this::mapRow,type);
    }

    @Override
    public void update(Formation entity) {
        throw new UnsupportedOperationException("non implémenté");
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("non implémenté");
    }

    private Formation mapRow(ResultSet rs) throws SQLException {
        return new Formation(
                rs.getLong("id_formation"),
                rs.getString("nom"),
                rs.getString("description"),
                rs.getInt("duree_jours"),
                rs.getString("type_formation"),
                rs.getDouble("prix")
        );
    }
}
