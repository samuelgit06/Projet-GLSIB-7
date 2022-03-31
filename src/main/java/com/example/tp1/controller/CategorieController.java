package com.example.tp1.controller;

import com.example.tp1.modele.Categorie;
import com.example.tp1.service.CategorieService;
import com.example.tp1.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Categorie")
public class CategorieController {
    @Autowired
    private CategorieService categorieService;

    @GetMapping("/afficher")
    public String ShowListCategorie(Model model){
        model.addAttribute("ListCategories",categorieService.showCategories());
        return  "Categorie/showCategorie";
    }

    @GetMapping("/formCategorie")
    public String formCategorie(){
        return  "Categorie/formCategorie";
    }

    @PostMapping("/save")
    public String saveCategorie(Categorie categorie){
        categorieService.saveCategorie(categorie);
        return  "redirect:/Categorie/afficher";
    }

    @GetMapping("/edit/{id}")
    public String editFormCategorie(@PathVariable("id") int id, Model model){
        model.addAttribute("uneCategorie",categorieService.showOneCategorie(id));
                return "Categorie/formEditCategorie";
    }

    @PostMapping("/edit")
    public String editCategorie(@ModelAttribute("Categorie") Categorie categorie){
        categorieService.saveCategorie(categorie);
        return "redirect:/Categorie/afficher";
    }


    @GetMapping ("delete/{id}")
    public String deleteCategorie(@PathVariable("id") int id)
    {
        categorieService.deleteCategorie(id);
        return "redirect:/Categorie/afficher";
    }





}
