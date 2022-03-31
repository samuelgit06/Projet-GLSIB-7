package com.example.tp1.controller;


        import com.example.tp1.modele.Produit;
        import com.example.tp1.service.ProduitService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.*;

        import java.time.LocalDate;
        import java.util.List;

@Controller
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @GetMapping("/afficher")
    public String displayProduct(Model model)
    {
        model.addAttribute("produits", produitService.ShowProduits());
        return "produits/showProduit";
    }

    @GetMapping("/form")
    public String renseign()
    {
        return "produits/produit";
    }

    @PostMapping("/save")
    public String saveProduit(Produit produit)
    {
        System.out.println("Libelle = "+ produit.getLibelle());
        produit.setDateCreation(LocalDate.now());
        produit.setQtStock(0);
        produitService.saveProduit(produit);
        return "redirect:/produits/afficher";
    }

    @GetMapping("edit/{id}")
    public String FormEdit(@PathVariable("id") int id , Model model){
        model.addAttribute("UnProduit", produitService.showOneProduit(id));
        return "produits/formUpdate";
    }
    @PostMapping("/edit")
    public String editProduit(@ModelAttribute("produit") Produit produit ){
        produitService.saveProduit(produit);
        return "redirect:/produits/afficher";


    }
    @GetMapping("delete/{id}")
    public String deleteProduit (@PathVariable("id") int id ){
        produitService.deleteProduit(id);
        return "redirect:/produits/afficher";
    }


}

