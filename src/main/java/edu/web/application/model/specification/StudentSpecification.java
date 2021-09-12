package edu.web.application.model.specification;

import edu.web.application.model.Student;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@And({
        @Spec(path = "name", spec = Equal.class),
        @Spec(path = "groupName", spec = Equal.class),
        @Spec(path = "subgroup", spec = Equal.class),
        @Spec(path = "cardNumber", spec = Equal.class),
        @Spec(path = "email", spec = Equal.class)
})
public interface StudentSpecification extends Specification<Student> {
}
