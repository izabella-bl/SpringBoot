package com.entretenimento.filmes_series.repository;

import com.entretenimento.filmes_series.model.Genero;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface GeneroRepository extends PagingAndSortingRepository<Genero,Integer>{
    
}