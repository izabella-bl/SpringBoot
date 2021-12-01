package com.entretenimento.filmes_series.repository;

import java.util.List;

import com.entretenimento.filmes_series.model.Filme;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FilmesRepository extends PagingAndSortingRepository<Filme,Integer> {

    @Override
    default Iterable<Filme> findAll() {
        
        return findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    List<Filme> findByNome(String nome);
    
}
