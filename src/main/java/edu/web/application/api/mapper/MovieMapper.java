package edu.web.application.api.mapper;

import edu.web.application.api.dto.MovieDto;
import edu.web.application.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public Movie to(MovieDto movieDto) {
        return Movie.builder()
                .id(movieDto.getId())
                .name(movieDto.getName())
                .author(movieDto.getAuthor())
                .build();
    }

    public MovieDto from(Movie movie) {
        return MovieDto.builder()
                .id(movie.getId())
                .name(movie.getName())
                .author(movie.getAuthor())
                .build();
    }
}
