package com.entretenimento.filmes_series.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.entretenimento.filmes_series.model.Genero;
import com.entretenimento.filmes_series.repository.GeneroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GeneroController {
    
    @Autowired
    private GeneroRepository repository;

    @GetMapping("/genero")
    public String generos(HttpServletRequest req ){
       
      List<Genero>lista = (List<Genero>)repository.findAll();
      req.setAttribute("generos", lista);
      return "genero";
    
    }

    @GetMapping("/genero/form")
    public String formulario(Model req){
        Genero model = new Genero();
        req.addAttribute("generos", model);
        return "genero-form";
    }

    @PostMapping("/genero/salvar")    
    public String salvar(Genero model){
        repository.save(model);
        return "redirect:/genero";
    }

    @GetMapping("/genero/deletar/{id}")
    public String deletar(@PathVariable int id){
        repository.deleteById(id);
        return "redirect:/genero";
    }

    @GetMapping("/genero/editar/{id}")
    public String editar(@PathVariable int id, Model req){
        Genero model = repository.findById(id).get();
        req.addAttribute("generos", model);
        return "genero-form";
    }
}
