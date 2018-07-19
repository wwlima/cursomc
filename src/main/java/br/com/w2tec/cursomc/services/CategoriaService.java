package br.com.w2tec.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.w2tec.cursomc.domain.Categoria;
import br.com.w2tec.cursomc.repositories.CategoriaRepository;
import br.com.w2tec.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow( () ->  new ObjectNotFoundException("Categoria: " + id + ", Tipo: " + Categoria.class.getName()));
	}

}
