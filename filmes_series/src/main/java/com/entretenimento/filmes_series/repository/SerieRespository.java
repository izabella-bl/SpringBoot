package com.entretenimento.filmes_series.repository;

import com.entretenimento.filmes_series.model.Serie;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SerieRespository extends PagingAndSortingRepository<Serie,Integer>{
    
    @Override
    default Iterable<Serie> findAll() {
        
        return findAll(Sort.by(Sort.Direction.ASC, "id"));
    }
}
