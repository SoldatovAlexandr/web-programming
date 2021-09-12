package edu.web.application.service;

import edu.web.application.api.dto.MovieDto;
import edu.web.application.exception.ProjectException;
import edu.web.application.model.specification.MovieSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MovieService {
    MovieDto get(Long id) throws ProjectException;

    MovieDto add(MovieDto movieDto);

    MovieDto update(Long id, MovieDto movieDto);

    void delete(Long id) throws ProjectException;

    Page<MovieDto> get(MovieSpecification specification, Pageable pageable);
}
