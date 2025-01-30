package com.toad.repositories;

import org.springframework.data.repository.CrudRepository;

import com.toad.entities.FilmDirector;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface FilmDirectorRepository extends CrudRepository<FilmDirector, Integer> {

}