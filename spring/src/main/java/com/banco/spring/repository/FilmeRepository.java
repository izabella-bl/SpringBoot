package com.banco.spring.repository;

import com.banco.spring.model.Filme;

import org.springframework.data.repository.CrudRepository;

public interface FilmeRepository extends CrudRepository<Filme,Integer>{
    
}
