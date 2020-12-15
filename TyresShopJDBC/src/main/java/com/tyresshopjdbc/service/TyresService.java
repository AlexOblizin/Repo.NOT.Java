package com.tyresshopjdbc.service;

import com.tyresshopjdbc.entity.Tyres;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface TyresService {

    String findTyres (int id) throws SQLException;

    String insertTyres (Tyres tyres) throws IOException, SQLException;

    String getAllTyres (List<Tyres> list) throws IOException,SQLException;
}
