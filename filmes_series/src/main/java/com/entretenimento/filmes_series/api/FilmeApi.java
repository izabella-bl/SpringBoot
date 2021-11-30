package com.entretenimento.filmes_series.api;

import java.util.List;

import com.entretenimento.filmes_series.model.Filme;
import com.entretenimento.filmes_series.repository.FilmesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilmeApi {

    @Autowired
    private FilmesRepository repository;
    
    @GetMapping("/api/filme")
    public List<Filme> filmes(){
        List<Filme> lista = (List<Filme>)repository.findAll();
        return lista;        
    }
    
    @PostMapping("/api/filme")    
    public String salvar(@RequestBody Filme model){
        repository.save(model);
        return "salvo com sucesso";
    }

    @DeleteMapping("/api/filme/{id}")    
    public String deletar(@PathVariable int id){
        repository.deleteById(id);
        return "deletado com sucesso";
    }

    @PutMapping("/api/filme/{id}")    
    public String update(@RequestBody Filme model, @PathVariable int id){
        if(model.getId() == id){
            repository.save(model);
            return "alterado com sucesso";
        }
        return "id da url diferente do body";
    }
}
