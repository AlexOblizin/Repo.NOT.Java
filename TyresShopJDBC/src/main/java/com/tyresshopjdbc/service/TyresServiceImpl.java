package com.tyresshopjdbc.service;

import com.tyresshopjdbc.dao.TyresDao;
import com.tyresshopjdbc.dao.impl.TyresDaoImpl;
import com.tyresshopjdbc.entity.Tyres;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TyresServiceImpl implements TyresService{


    TyresDao tyresDao = new TyresDaoImpl();

    public TyresServiceImpl() throws IOException {
    }


    @Override
    public String findTyres(int id) throws SQLException {
        Tyres findTyres = tyresDao.findByIdTyres(id);

        if (id == 0) {
            return "No iD entered";
        }

        if (findTyres != null) {
            if (id == findTyres.getId()) {
                return "Ok! Tyres params are: ID: " + id + " model: "
                        + findTyres.getModel() + " heigth: "
                        + findTyres.getHeigth() + " width: "
                        + findTyres.getWidth() + " radius: "
                        + findTyres.getRadius() + " type: "
                        + findTyres.getType() + " price: "
                        + findTyres.getPrice();
            }

        }

        return "No such position!";
    }

    @Override
    public String insertTyres(Tyres tyres) throws IOException, SQLException {
        Tyres newTyres = tyresDao.findByIdTyres(tyres.getId());
        if(newTyres == null) {
            tyresDao.saveTyres(tyres);
            return "Fine!";
        }

        return "This tyres already in the base!";

    }

    @Override
    public String getAllTyres(List<Tyres> list) throws IOException, SQLException{
    List<Tyres> tyresList = new ArrayList<>();
    tyresList.addAll(list);

        return null;
    }
}
