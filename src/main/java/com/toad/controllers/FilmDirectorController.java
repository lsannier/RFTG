package com.toad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.toad.entities.FilmDirector;
import com.toad.repositories.FilmDirectorRepository;

@Controller
@RequestMapping(path = "/toad/film_director")
public class FilmDirectorController {
    @Autowired
    private FilmDirectorRepository filmDirectorRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewFilmDirector(
            @RequestParam Integer filmId,
            @RequestParam Integer directorId) {
        
        FilmDirector filmDirector = new FilmDirector();
        filmDirectorRepository.save(filmDirector);
        return "FilmDirector Sauvegardé";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<FilmDirector> getAllFilmDirectors() {
        return filmDirectorRepository.findAll();
    }

    @GetMapping(path="/getById")
    public @ResponseBody FilmDirector getFilmDirectorById(@RequestParam Integer id) {
        FilmDirector filmDirector = filmDirectorRepository.findById(id).orElse(null);
        return filmDirector;
    }

    @PutMapping(path = "/update/{id}")
    public @ResponseBody String updateFilmDirector(
            @PathVariable Integer id,
            @RequestParam Integer filmId,
            @RequestParam Integer directorId) {
        
        String status;
        if (filmDirectorRepository.existsById(id)) {
            FilmDirector filmDirector = filmDirectorRepository.findById(id).orElse(null);
            filmDirector.setFilmId(filmId);
            filmDirector.setDirectorId(directorId);
    
            filmDirectorRepository.save(filmDirector);
            status = "FilmDirector Mis à jour";
        } else {
            status = "FilmDirector non trouvé";
        }
        return status;
    }

    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody String deleteFilmDirector(@PathVariable Integer id) {
        String status;
        if (filmDirectorRepository.existsById(id)) {
            filmDirectorRepository.deleteById(id);
            status = "FilmDirector supprimé";
        } else {
            status = "FilmDirector pas trouvé";
        }
        return status;
    }
}
