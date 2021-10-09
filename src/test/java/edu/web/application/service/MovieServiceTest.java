package edu.web.application.service;

import edu.web.application.api.dto.MovieDto;
import edu.web.application.api.mapper.MovieMapper;
import edu.web.application.exception.ProjectException;
import edu.web.application.model.Movie;
import edu.web.application.repository.MovieRepository;
import edu.web.application.service.impl.MovieServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieServiceTest {

    private MovieService movieService;

    private final MovieRepository repository = Mockito.mock(MovieRepository.class);
    private final MovieMapper movieMapper = new MovieMapper();
    private final Movie movie = Movie.builder()
            .id(1L)
            .name("Звездные войны")
            .author("Джордж Лукас")
            .build();
    private final MovieDto movieDto = MovieDto.builder()
            .id(1L)
            .name("Звездные войны")
            .author("Джордж Лукас")
            .build();

    @BeforeEach
    void setUp() {
        movieService = new MovieServiceImpl(repository, movieMapper);
    }

    @Test
    void get_success() throws ProjectException {
        when(repository.findById(1L)).thenReturn(Optional.of(movie));

        MovieDto resultDto = movieService.get(1L);

        assertEquals(movieDto, resultDto);
        verify(repository).findById(1L);
    }

    @Test
    void get_error() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        Assertions.assertThrows(ProjectException.class, () -> movieService.get(1L));
    }

    @Test
    void add_success() {
        when(repository.save(movie)).thenReturn(movie);

        MovieDto resultDto = movieService.add(movieDto);

        assertEquals(movieDto, resultDto);
        verify(repository).save(movie);
    }

    @Test
    void update_success() throws ProjectException {
        when(repository.findById(1L)).thenReturn(Optional.of(movie));
        when(repository.save(movie)).thenReturn(movie);

        MovieDto resultDto = movieService.update(1L, movieDto);

        assertEquals(movieDto, resultDto);
    }

    @Test
    void delete_success() throws ProjectException {
        when(repository.findById(1L)).thenReturn(Optional.of(movie));

        movieService.delete(1L);

        verify(repository).findById(1L);
        verify(repository).delete(movie);
    }

    @Test
    void delete_error() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ProjectException.class, () -> movieService.delete(1L));
    }
}
