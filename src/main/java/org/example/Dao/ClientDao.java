package org.example.Dao;

import org.example.Class.Client;
import org.example.Dao.Helper.DaoHelper;
import org.example.Dao.Interface.InterfaceDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClientDao extends DaoHelper implements InterfaceDao<Client> {

    @Override
    public void save(Client entity) {
        throw new UnsupportedOperationException("non implémenté");
    }

    @Override
    public Client findById(Long id) {
        String sql = "SELECT * FROM client WHERE id_client=?";
        return DaoHelper.executeQuerySingle(sql, this::mapRow,id);}

    @Override
    public List<Client> findAll() {
        throw new UnsupportedOperationException("non implémenté");
    }

    @Override
    public void update(Client entity) {
        throw new UnsupportedOperationException("non implémenté");
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("non implémenté");
    }

    private Client mapRow(ResultSet  rs) throws SQLException {
        return new Client(
                rs.getLong("id_client"),
                rs.getString("telephone"),
                rs.getString("adresse"),
                rs.getString("email"),
                rs.getString("prenom"),
                rs.getString("nom")
                );
    }
}
