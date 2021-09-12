package edu.web.application.service;

import edu.web.application.api.dto.MovieDto;
import edu.web.application.exception.ProjectException;

public interface MovieService {
    MovieDto get(Long id) throws ProjectException;

    MovieDto add(MovieDto movieDto);

    MovieDto update(Long id, MovieDto movieDto);

    void delete(Long id) throws ProjectException;
}
