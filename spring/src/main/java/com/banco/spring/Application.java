package com.banco.spring;



import java.util.List;

import com.banco.spring.model.Filme;
import com.banco.spring.repository.FilmeRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner{
	private FilmeRepository repository;


	public Application(FilmeRepository repository){
		this.repository = repository;

	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);			
	}

	@Override
	public void run(String... args) throws Exception {
		Filme filme = new Filme();
		filme.setId(3);
		filme.setNome("Harry Potter");
		filme.setNomeDiretor("David Yates");
		filme.setGenero("Aventura");
		
		//repository.save(filme);

		/*List<Filme> lista = (List<Filme>)repository.findAll();
		for (Filme f : lista) {
			System.out.printf("%d - %s\n", f.getId(), f.getNome());
		}*/

		repository.deleteById(2);
		repository.findAll().forEach(f-> System.out.printf("%d - %s\n", f.getId(), f.getNome()));

	}

}
