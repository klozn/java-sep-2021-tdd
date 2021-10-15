package com.switchfully.rest.moviebase.webapi;

import com.switchfully.rest.moviebase.domain.Movie;
import com.switchfully.rest.moviebase.domain.MovieRepository;
import com.switchfully.rest.moviebase.webapi.dtos.CreateMovieDto;
import com.switchfully.rest.moviebase.webapi.dtos.MovieDto;
import com.switchfully.rest.moviebase.webapi.dtos.UpdateMovieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieRepository repository;

    @Autowired
    public MovieController(MovieRepository repository) {
        this.repository = repository;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(value = HttpStatus.CREATED)
    public MovieDto createMovie(@RequestBody CreateMovieDto createMovieDto) {
        Movie movie = new Movie(createMovieDto.getTitle(), createMovieDto.getDescription(),
                createMovieDto.getRuntimeInSeconds());
        return toDto(repository.save(movie));
    }

    @GetMapping(produces = "application/json")
    public List<MovieDto> getAllMovies() {
        return repository.getAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public MovieDto getMovieById(@PathVariable String id) {
        return toDto(repository.getById(id));
    }

    @PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
    public MovieDto updateMovie(@PathVariable String id, @RequestBody UpdateMovieDto updateMovieDto) {
        Movie toUpdate = repository.getById(id);
        toUpdate.setTitle(updateMovieDto.getTitle());
        toUpdate.setDescription(updateMovieDto.getDescription());
        toUpdate.setRuntimeInSeconds(updateMovieDto.getRuntimeInSeconds());
        return toDto(repository.save(toUpdate));
    }

    private MovieDto toDto(Movie movie) {
        var dto = new MovieDto();
        dto.setId(movie.getId());
        dto.setTitle(movie.getTitle());
        dto.setDescription(movie.getDescription());
        dto.setRuntimeInSeconds(movie.getRuntimeInSeconds());
        return dto;
    }
}
