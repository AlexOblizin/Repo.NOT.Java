package com.tyresshop.dao;

import com.tyresshop.entity.Tyres;

import java.io.IOException;
import java.sql.SQLException;

public interface TyresDao {

    Tyres findByIdTyres(String idTyres) throws SQLException;

    Boolean save(Tyres tyres) throws IOException;

}
