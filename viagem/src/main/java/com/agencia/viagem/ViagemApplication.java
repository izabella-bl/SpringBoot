package com.agencia.viagem;

import com.agencia.viagem.model.Agencia;
import com.agencia.viagem.model.Cliente;
import com.agencia.viagem.repository.AgenciaRepository;
import com.agencia.viagem.repository.ClienteRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ViagemApplication  implements CommandLineRunner{
	private ClienteRepository cr;
	private AgenciaRepository ar;

	public ViagemApplication(ClienteRepository cRepository ,AgenciaRepository aRepository){
             this.ar = aRepository;
			 this.cr = cRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ViagemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Cliente modelCliente = new Cliente();
		Agencia modelAgencia = new Agencia();

		//modelCliente.setId(3);
		modelCliente.setNome("Leandra");
		modelCliente.setSobrenome("de Oliveira");
		modelCliente.setIdade(44);

		//cr.save(modelCliente);
		//cr.save(modelCliente);
		//cr.deleteById(7);

		modelAgencia.setNome("Agencia de viagem 3");
		modelAgencia.setTelefone("(62)83828-9829");
		//ar.save(modelAgencia);

		ar.findAll().forEach(a -> System.out.printf("%d - %s  %s \n",a.getId(),a.getNome(),a.getTelefone()));
		System.out.println("\n");
		
		cr.findAll().forEach(c -> System.out.printf("%d - %s %s - %d \n",c.getId(),c.getNome(),c.getSobrenome(),c.getIdade()));
		System.out.println("\n");


	}

}
