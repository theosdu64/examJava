package org.example.Dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.Class.Formation;
import org.example.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class Formation_Dao implements InterfaceDao<Formation> {
    @Override
    public void save(Formation entity) {
        throw new UnsupportedOperationException("non implémenté");
    }

    @Override
    public Formation findById(Long id) {
        throw new UnsupportedOperationException("non implémenté");
    }

    @Override
    public List<Formation> findAll() {
        throw new UnsupportedOperationException("non implémenté");
    }

    @Override
    public void update(Formation entity) {
        throw new UnsupportedOperationException("non implémenté");
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("non implémenté");
    }
}
