package tr.com.nekasoft.springjavers.controller;

import lombok.RequiredArgsConstructor;
import org.javers.core.Changes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tr.com.nekasoft.springjavers.entity.Foo;
import tr.com.nekasoft.springjavers.service.FooService;

@RestController
@RequiredArgsConstructor
public class FooController {

    private final FooService fooService;

    @GetMapping(path = "/save")
    public ResponseEntity<String> persistFoo() {
        Foo foo = new Foo();
        String savedId = fooService.save(foo);
        return ResponseEntity.ok(savedId);
    }

    @GetMapping(path = "/update/{id}")
    public void updateFoo(@PathVariable("id") String id) {
        fooService.update(id);
    }

    @GetMapping(path = "/history/{id}")
    public ResponseEntity<Changes> historyFoo(@PathVariable("id") String id) {
        Changes history = fooService.history(id);
        return ResponseEntity.ok(history);
    }

}
