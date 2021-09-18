package edu.web.application.model.specification;

import edu.web.application.model.Hotel;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@And({
        @Spec(path = "name", spec = Like.class),
        @Spec(path = "directorName", spec = Like.class),
        @Spec(path = "countVisitor", spec = Like.class),
        @Spec(path = "address", spec = Like.class)
})
public interface HotelSpecification extends Specification<Hotel> {
}
