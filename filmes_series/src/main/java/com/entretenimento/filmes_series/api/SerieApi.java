package com.entretenimento.filmes_series.api;

import java.util.List;

import com.entretenimento.filmes_series.model.Serie;
import com.entretenimento.filmes_series.repository.SerieRespository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SerieApi {
    
    @Autowired
    private SerieRespository repository;
    
    @GetMapping("/api/serie")
    public List<Serie> series(){
        List<Serie> lista = (List<Serie>)repository.findAll();
        return lista;        
    }
    
    @PostMapping("/api/serie")    
    public String salvar(@RequestBody Serie model){
        repository.save(model);
        return "salvo com sucesso";
    }

    @DeleteMapping("/api/serie/{id}")    
    public String deletar(@PathVariable int id){
        repository.deleteById(id);
        return "deletado com sucesso";
    }

    @PutMapping("/api/serie/{id}")    
    public String update(@RequestBody Serie model, @PathVariable int id){
        if(model.getId() == id){
            repository.save(model);
            return "alterado com sucesso";
        }
        return "id da url diferente do body";
    }
}
