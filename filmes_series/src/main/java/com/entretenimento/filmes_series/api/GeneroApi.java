package com.entretenimento.filmes_series.api;

import java.util.List;

import com.entretenimento.filmes_series.model.Genero;
import com.entretenimento.filmes_series.repository.GeneroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/genero")
public class GeneroApi {
    
    @Autowired
    private GeneroRepository repo;
    
    @GetMapping
    public List<Genero> list(){
        return (List<Genero>)repo.findAll();
    }
    
    @PostMapping
    public String create(@RequestBody Genero model){
        repo.save(model);
        return "Salva com sucesso";
    }

   
    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Genero model){
        model.setId(id);
        repo.save(model);
        return "Alterado com sucesso!";     
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        repo.deleteById(id);
        return "Deletado com sucesso!";
    }
}