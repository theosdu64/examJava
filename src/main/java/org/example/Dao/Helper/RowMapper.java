package org.example.Dao.Helper;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface RowMapper<T> {
    T map(ResultSet rs) throws SQLException;
}
