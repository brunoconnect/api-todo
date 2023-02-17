package com.connect.apitodo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.connect.apitodo.model.Todo;

public interface TodoRepositories extends JpaRepository<Todo, Long> {

}
