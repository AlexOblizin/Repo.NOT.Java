package com.tyresshop.service;

import com.tyresshop.entity.Tyres;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public interface TyresService {


    List<Tyres> getAll();

    Tyres getById(Integer id);


    Tyres putIntoBase(Tyres tyres);

}
