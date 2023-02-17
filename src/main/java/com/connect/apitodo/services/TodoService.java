package com.connect.apitodo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connect.apitodo.model.Todo;
import com.connect.apitodo.repositories.TodoRepositories;



@Service
public class TodoService {
	@Autowired
	private TodoRepositories todoRepository;

	public List<Todo> obterTodos() {

		return todoRepository.findAll();
	}

	public Optional<Todo> obterPorId(Long id) {

		return todoRepository.findById(id);

	}

	public Todo adicionar(Todo tipo) {

		tipo.setId(null);
		return todoRepository.save(tipo);

	}

	public void deletar(Long id) {
		todoRepository.deleteById(id);
	}

	public Todo atualizar(Long id, Todo tipo) {

		tipo.setId(id);
		return todoRepository.save(tipo);

	}
}
