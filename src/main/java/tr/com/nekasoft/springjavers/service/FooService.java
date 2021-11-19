package tr.com.nekasoft.springjavers.service;

import org.javers.core.Changes;
import tr.com.nekasoft.springjavers.entity.Foo;

public interface FooService {
    String save(Foo foo);

    void update(String id);

    Changes history(String id);
}
