package br.com.w2tec.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.w2tec.cursomc.domain.Categoria;
import br.com.w2tec.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	/*// Inserts para testes do código.
	insert into categoria (id,nome) values(1,'Informática');
	insert into categoria (id,nome) values(2,'Escritório');
	*/
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);		
	}
	
}
