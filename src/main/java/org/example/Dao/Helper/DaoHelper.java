package org.example.Dao.Helper;

import org.example.Class.Formation;
import org.example.ConnexionBDD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class DaoHelper {

    public static <T> List<T> executeQuery(String sql, RowMapper<T> mapper, Object... params) {
        List<T> results = new ArrayList<>();
        try (Connection conn = ConnexionBDD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    results.add(mapper.map(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public static <T> T executeQuerySingle(String sql, RowMapper<T> mapper, Object... params) {
        List<T> results = executeQuery(sql, mapper, params);
        return results.isEmpty() ? null : results.get(0);
    }

    public static int executeUpdate(String sql, Object... params) {
        try (Connection conn = ConnexionBDD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }

            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

}

