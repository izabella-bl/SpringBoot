package com.agencia.viagem.repository;

import com.agencia.viagem.model.Cliente;

import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente,Integer> {
    
}
