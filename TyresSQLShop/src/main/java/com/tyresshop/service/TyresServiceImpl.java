package com.tyresshop.service;
import com.tyresshop.entity.Tyres;
import com.tyresshop.repository.TyresRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TyresServiceImpl implements TyresService {

    private final TyresRepository tyresRepository;

    public TyresServiceImpl(TyresRepository tyresRepository) {
        this.tyresRepository = tyresRepository;

    }

    @Override
    public List<Tyres> getAll() {
        return tyresRepository.findAll();
    }



    @Override
    public Tyres getById(Integer id) {
        return tyresRepository.findById(id).get();
    }


    @Override
    public Tyres putIntoBase(Tyres tyres) {
        return tyresRepository.save(tyres);

    }
}

// ->ORM (OOP) Hibernate
// Spring Data

// ORM: Hibernate (Java), Doctrine (PHP)
// JPA: JPA - Hibernate
// Spring DATA(JPA(Hibernate))