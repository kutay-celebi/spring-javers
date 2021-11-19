package tr.com.nekasoft.springjavers.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tr.com.nekasoft.springjavers.entity.Bar;
import tr.com.nekasoft.springjavers.entity.Foo;


@Repository
public interface BarRepository extends CrudRepository<Bar, String> {
}
