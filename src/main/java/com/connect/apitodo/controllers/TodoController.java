package com.connect.apitodo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.connect.apitodo.model.Todo;
import com.connect.apitodo.services.TodoService;


@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {

	@Autowired
	private TodoService todoService;

	
	@GetMapping
	public List<Todo> obterTodos() {
		return todoService.obterTodos();
	}

	
	@GetMapping("/{id}")
	public Optional<Todo> obterporId(@PathVariable Long id) {
		return todoService.obterPorId(id);
	}
	
	@PostMapping
	public Todo adicionar(@RequestBody Todo todo) {
		return todoService.adicionar(todo);

	}

	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		todoService.deletar(id);
	}


	
	@PutMapping("/{id}")
	public Todo atualizar(@PathVariable Long id, @RequestBody Todo todo) {
		return todoService.atualizar(id, todo);

	}

}
