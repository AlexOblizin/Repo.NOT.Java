package com.tyresshopjdbc.controller;

import com.tyresshopjdbc.entity.Tyres;
import com.tyresshopjdbc.service.TyresService;
import com.tyresshopjdbc.service.TyresServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.sql.SQLException;

@RestController
public class TyresController {
    TyresService tyresService = new TyresServiceImpl();

    public TyresController() throws IOException {
    }


    @RequestMapping("/tyresid")
    ModelAndView findTyresForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("findtyresbyid.html");

        return modelAndView;
    }

    @PostMapping("/tyresid")
    String findTyresById(@RequestParam int id) throws SQLException {

        return tyresService.findTyres(id);
    }


    @RequestMapping("/regtyres")
    ModelAndView regForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("insertnewtyres.html");

        return modelAndView;
    }

    @PostMapping("/regtyres")
    String regTyres(@RequestParam int heigth,
                    @RequestParam int width,
                    @RequestParam int radius,
                    @RequestParam String model,
                    @RequestParam String type,
                    @RequestParam int price) throws IOException, SQLException {

        Tyres tyres = new Tyres();

        tyres.setHeigth(heigth);
        tyres.setWidth(width);
        tyres.setRadius(radius);
        tyres.setModel(model);
        tyres.setType(type);
        tyres.setPrice(price);

        return tyresService.insertTyres(tyres);

    }

    @RequestMapping("/getalltyres")
    ModelAndView allTyresForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("getalltyres.html");

        return modelAndView;
    }




    @PostMapping("/getalltyres")
    String getAll () throws IOException, SQLException {
        return tyresService.getAllTyres();

    }


}