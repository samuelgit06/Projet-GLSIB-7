package com.example.tp1.controller;

import com.example.tp1.modele.Categorie;
import com.example.tp1.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.engine.AttributeName;

@Controller
@RequestMapping("/categorie")
public class CategorieContoller {

    @Autowired
    private CategorieService categorieService;

    public  String showListCategorie(Model model)
    {
        model.addAttribute(AttributeName : "Listecategories",categorieService.showAllCategorie());
        return "categorie/showCategorie";

    }

    @GetMapping("/formCategorie")
    public  String formCategory()
    {
        return  "category/formCategorie";
    }


     public  String saveCategorie(Categorie categorie){
        categorieService.save(categorie);
        return "redirect:/category/afficher";
     }

     @GetMapping("/edit/{id}")
    public  String editFormCategorie(@PathVariable("id") int id ,Model model){
        model.addAttribute(AttributeName :"uneCategorie" Categorie )
     }

}
