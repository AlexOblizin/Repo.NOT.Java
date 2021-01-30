package com.tyresshop.controller;

import com.tyresshop.entity.Tyres;
import com.tyresshop.service.TyresService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/tyres")
public class TyresController {

    private final TyresService tyresService;



    public TyresController(TyresService tyresService) {
        this.tyresService = tyresService;
    }

    @GetMapping
    public List<Tyres> getAll() {
        return tyresService.getAll();
    }

    @GetMapping("/{id}")
    public Tyres getById(@PathVariable Integer id) {

        return tyresService.getById(id);
    }



    @RequestMapping("/findtyres")
    ModelAndView loginForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("findTyres.html");
        return modelAndView;
    }

    @RequestMapping("/regtyres")
    ModelAndView registrationForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("putIntoBaseTyres.html");
        return modelAndView;
    }


}

// CRUD
// REST API - HTTP: GET, POST, PUT, DELETE

// GET localhost:8080/tyres/1