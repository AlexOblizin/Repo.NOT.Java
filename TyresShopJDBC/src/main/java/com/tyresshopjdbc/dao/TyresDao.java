package com.tyresshopjdbc.dao;

import com.tyresshopjdbc.entity.Tyres;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface TyresDao {

    Tyres findByIdTyres (int idTyres) throws SQLException;

    Boolean saveTyres (Tyres tyres) throws IOException;

    List<Tyres> getAll() throws SQLException;


}
