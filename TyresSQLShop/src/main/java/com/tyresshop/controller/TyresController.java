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

    // CRUD
    // REST API - HTTP: GET, POST, PUT, DELETE
    // URL - www.yandex.ru

    // GET localhost:8080/tyres/1

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

    @PostMapping("/findtyres")
    String findTyres(@RequestParam int id) throws SQLException {

        return tyresService.findTyres(id);
    }

    @PostMapping("/regtyres")
    String putIntoBase(@RequestParam int heigth,
                       @RequestParam int width,
                       @RequestParam int radius,
                       @RequestParam String model,
                       @RequestParam String type,
                       @RequestParam int price) throws IOException, SQLException {

        Tyres tyres = new Tyres(heigth, width, radius, model, type, price);
        tyres.setHeigth(heigth);
        tyres.setWidth(width);
        tyres.setRadius(radius);
        tyres.setModel(model);
        tyres.setType(type);
        tyres.setPrice(price);
        return tyresService.putIntoBase(tyres);
    }

}

