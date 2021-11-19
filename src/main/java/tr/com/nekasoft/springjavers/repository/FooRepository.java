package tr.com.nekasoft.springjavers.repository;

import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tr.com.nekasoft.springjavers.entity.Foo;


@Repository
public interface FooRepository extends CrudRepository<Foo, String> {
}
