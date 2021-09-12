package edu.web.application.service.impl;

import edu.web.application.api.dto.MovieDto;
import edu.web.application.api.mapper.MovieMapper;
import edu.web.application.exception.ProjectException;
import edu.web.application.model.Movie;
import edu.web.application.model.specification.MovieSpecification;
import edu.web.application.repository.MovieRepository;
import edu.web.application.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Override
    public MovieDto get(Long id) throws ProjectException {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ProjectException("Фильм не найден."));
        return movieMapper.from(movie);
    }

    @Override
    public MovieDto add(MovieDto movieDto) {
        Movie movie = movieMapper.to(movieDto);
        movieRepository.save(movie);
        return movieMapper.from(movie);
    }

    @Override
    public MovieDto update(Long id, MovieDto movieDto) {
        Movie movie = movieMapper.to(movieDto);
        movieRepository.save(movie);
        return movieMapper.from(movie);
    }

    @Override
    public void delete(Long id) throws ProjectException {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ProjectException("Фильм не найден."));
        movieRepository.delete(movie);
    }

    @Override
    public Page<MovieDto> get(MovieSpecification specification, Pageable pageable) {
        return movieRepository.findAll(specification, pageable).map(movieMapper::from);
    }
}
