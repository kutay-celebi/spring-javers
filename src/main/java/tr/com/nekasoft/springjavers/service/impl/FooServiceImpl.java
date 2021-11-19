package tr.com.nekasoft.springjavers.service.impl;

import lombok.RequiredArgsConstructor;
import org.javers.core.Changes;
import org.javers.core.Javers;
import org.javers.repository.jql.QueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.nekasoft.springjavers.entity.Bar;
import tr.com.nekasoft.springjavers.entity.Foo;
import tr.com.nekasoft.springjavers.repository.FooRepository;
import tr.com.nekasoft.springjavers.service.FooService;

import java.util.Optional;
import java.util.UUID;

@Transactional
@Service
@RequiredArgsConstructor
public class FooServiceImpl implements FooService {

    private final FooRepository fooRepository;
    private final Javers javers;

    @Override
    public String save(Foo foo) {
        Foo save = fooRepository.save(foo);
        javers.commit("author", save);
        return save.getId();
    }

    @Override
    public void update(String id) {
        Optional<Foo> fooOptional = fooRepository.findById(id);

        if (fooOptional.isPresent()) {

            Bar bar = new Bar();
            bar.setBar(UUID.randomUUID().toString());
            fooOptional.get().setBar(bar);

            Foo updatedFoo = fooRepository.save(fooOptional.get());
            javers.commit("author2", updatedFoo);
        }
    }

    @Override
    public Changes history(String id) {
        QueryBuilder javersQuery = QueryBuilder.byInstanceId(id, Foo.class);
        return javers.findChanges(javersQuery.build());
    }
}
