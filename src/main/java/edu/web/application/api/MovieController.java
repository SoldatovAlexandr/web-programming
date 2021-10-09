package edu.web.application.api;

import edu.web.application.api.dto.MovieDto;
import edu.web.application.api.dto.StudentDto;
import edu.web.application.exception.ProjectException;
import edu.web.application.model.specification.MovieSpecification;
import edu.web.application.model.specification.StudentSpecification;
import edu.web.application.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/{id}")
    public MovieDto get(@PathVariable("id") Long id) throws ProjectException {
        log.info("Get movie bu id [{}]", id);
        return movieService.get(id);
    }

    @PostMapping("/")
    public MovieDto add(@Valid @RequestBody MovieDto movieDto) {
        log.info("Add new movie with request [{}]", movieDto);
        return movieService.add(movieDto);
    }

    @PutMapping("/{id}")
    public MovieDto update(@PathVariable("id") Long id, @Valid @RequestBody MovieDto movieDto) throws ProjectException {
        log.info("Update movie with request [{}]", movieDto);
        return movieService.update(id, movieDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws ProjectException {
        log.info("Delete movie by id [{}]", id);
        movieService.delete(id);
    }

    @GetMapping("/")
    public Page<MovieDto> get(MovieSpecification specification, Pageable pageable) {
        log.info("Get movies by specification [{}]", specification);
        return movieService.get(specification, pageable);
    }
}
