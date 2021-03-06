package edu.web.application.model.specification;

import edu.web.application.model.Movie;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@And({
        @Spec(path = "name", spec = Like.class),
        @Spec(path = "author", spec = Like.class)
})
public interface MovieSpecification extends Specification<Movie> {
}
