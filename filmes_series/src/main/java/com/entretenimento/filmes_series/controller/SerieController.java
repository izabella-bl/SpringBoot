package com.entretenimento.filmes_series.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.entretenimento.filmes_series.model.Serie;
import com.entretenimento.filmes_series.repository.SerieRespository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SerieController {
    private SerieRespository repository;

    public SerieController(SerieRespository repository){
        this.repository = repository;

    }
    
    @GetMapping("/serie")
    public String series(HttpServletRequest req){
        List<Serie>lista = (List<Serie>)repository.findAll();
        req.setAttribute("series", lista);
        return "series";
    }

    @GetMapping("/serie/form")
    public String formulario(Model req){
        Serie model = new Serie();
        req.addAttribute("serie", model);
        return "series-form";
    }

    @PostMapping("/serie/salvar")    
    public String salvar(Serie model){
        repository.save(model);
        return "redirect:/serie";
    }

    @GetMapping("/serie/deletar/{id}")
    public String deletar(@PathVariable int id){
        repository.deleteById(id);
        return "redirect:/serie";
    }

    @GetMapping("/serie/editar/{id}")
    public String editar(@PathVariable int id, Model req){
        Serie model = repository.findById(id).get();
        req.addAttribute("serie", model);
        return "series-form";
    }
}
