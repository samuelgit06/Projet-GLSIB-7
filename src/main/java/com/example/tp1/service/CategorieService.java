package com.example.tp1.service;

import com.example.tp1.modele.Categorie;
import com.example.tp1.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService  {
    @Autowired
    private CategorieRepository categorieRepository;

    public void save(Categorie categorie)
    {
        categorieRepository.save(categorie);
    }

    public List<Categorie> showAllCategorie(){
        return  categorieRepository.findAll();
    }
    public  Categorie SelectOneCategorie(int id ){
        return  categorieRepository.findbyId(id).get();
    }
    public  void  deleteCategorie(int id)
    {
        categorieRepository.deleteById(id);
    }
}
