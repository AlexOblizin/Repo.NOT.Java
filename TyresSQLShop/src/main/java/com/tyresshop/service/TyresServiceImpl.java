package com.tyresshop.service;

import com.tyresshop.dao.TyresDao;
import com.tyresshop.dao.impl.TyresDaoImpl;
import com.tyresshop.entity.Tyres;
import com.tyresshop.repository.TyresRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Service
public class TyresServiceImpl implements TyresService {

    private final TyresRepository tyresRepository;
    private TyresDao tyresDao;

    public TyresServiceImpl(TyresRepository tyresRepository) {
        this.tyresRepository = tyresRepository;

        try {
            this.tyresDao = new TyresDaoImpl();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Tyres> getAll() {
        return tyresRepository.findAll();
    }

    @Override
    public Tyres getById(Integer id) {
        return tyresRepository.findById(id).get();
    }

// ->ORM (OOP) Hibernate
    // Spring Data

    // ORM: Hibernate (Java), Doctrine (PHP)
    // JPA: JPA - Hibernate
    // Spring DATA(JPA(Hibernate))




    @Override
    public String findTyres(int id) throws SQLException {
        Tyres findTyres = tyresDao.findByIdTyres(id);
        if (id == 0) {
            return "No iD entered";
        }
        if (findTyres != null) {
            if ((id == findTyres.getId())) {
                return "Ok! Tyres params are: " + findTyres.getId() + " " + findTyres.getModel() + " " + findTyres.getHeigth()
                        + findTyres.getId() + " " + findTyres.getWidth() + findTyres.getId() + " " + findTyres.getRadius()
                        + findTyres.getId() + " " + findTyres.getPrice();
            }

        }
        return "No such position!";
    }



    @Override
    public String putIntoBase(Tyres tyres) throws IOException, SQLException {
        Tyres findTyres = tyresDao.findByIdTyres(tyres.getId());
        if (findTyres == null) {
            tyresDao.save(tyres);
            return "Fine!";
        }
        return "this tyres is not available";
    }


}