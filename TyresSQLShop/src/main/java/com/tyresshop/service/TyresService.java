package com.tyresshop.service;

import com.tyresshop.entity.Tyres;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public interface TyresService {

    String findTyres(int id) throws SQLException;

    List<Tyres> getAll();

    Tyres getById(Integer id);


    String putIntoBase(Tyres tyres) throws IOException, SQLException;

}
