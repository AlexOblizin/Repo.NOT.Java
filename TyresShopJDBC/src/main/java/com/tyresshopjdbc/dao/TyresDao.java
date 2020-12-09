package com.tyresshopjdbc.dao;

import com.tyresshopjdbc.entity.Tyres;

import java.io.IOException;
import java.sql.SQLException;

public interface TyresDao {

    Tyres findByIdTyres (int idTyres) throws SQLException;

    Boolean save (Tyres tyres) throws IOException;


}
